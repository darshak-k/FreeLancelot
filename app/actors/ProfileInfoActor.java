package actors;

/**
 * Profile projects data Actor
 * 
 * @author Apekshaba Gohil
 */

import akka.actor.AbstractActor;
import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import models.APIResponse;
import models.SearchResult;
import play.mvc.Result;
//import views.html.profile;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletionStage;

import static play.mvc.Results.redirect;

public class ProfileInfoActor extends AbstractActor {
    public static List<SearchResult> ProfileProjectsResults = new ArrayList<>();
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final WSClient ws;
    private static final int RESULT_COUNT = 10;
    private static String baseURL = "https://www.freelancer.com/api";
    private ObjectMapper mapper;

    @Inject
    public ProfileInfoActor(WSClient ws) {
        this.ws = ws;
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static Props props(WSClient ws) {
        return Props.create(ProfileInfoActor.class, ws);
    }

    @Override
    public void preStart() {

        log.info("ProfileInfoActor {}-{} started at ", this, LocalTime.now());
    }

    @Override
    public void postStop() {
        log.info("ProfileInfoActor {}-{} stopped at ", this, LocalTime.now());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.ProfileInfoActorMessage.class, this::searchOwnerProjects)
                .build();
    }

    private void searchOwnerProjects(Messages.ProfileInfoActorMessage ownerID) {
        final ActorRef senderRef = sender();
        ws.url(baseURL + "/projects/0.1/projects?owners[]=" + String.valueOf(ownerID.ownerId))
                .addHeader("freelancer-oauth-v1", "l12Bz0qvwEkZVSvwzFds2EBSGGhDqa")
                .addQueryParameter("job_details", "true")
                .addQueryParameter("query", String.valueOf(ownerID.ownerId))
                .addQueryParameter("limit", String.valueOf(RESULT_COUNT))
                .get()
                .thenApplyAsync(WSResponse::asJson)
                .toCompletableFuture()
                .thenApplyAsync(result -> {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

                    try {
                        APIResponse project = mapper.treeToValue(result, APIResponse.class);
                        SearchResult searchResult = new SearchResult();
                        searchResult.setQuery(String.valueOf(ownerID.ownerId));
                        searchResult.setProjects(project.getResult().getProjects());
                        ProfileProjectsResults.clear();
                        ProfileProjectsResults.add(0, searchResult);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return ProfileProjectsResults;

                }).thenAccept(

                        response -> {
                            
                            senderRef.tell((List<SearchResult>) response, self());
                        });
    }
}