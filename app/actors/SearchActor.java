package actors;

/**
 * Search Projects Actor
 * 
 *  @author Darshak Kachchhi, Mansi Lakhani, Apekshaba Gohil
 */

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.APIResponse;
import models.SearchResult;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SearchActor extends AbstractActor {
    public static List<SearchResult> projects = new ArrayList<>();
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final WSClient ws;
    private static final int RESULT_COUNT = 10;
    private static String baseURL = "https://www.freelancer.com/api";
    private ObjectMapper mapper;

    @Inject
    public SearchActor(WSClient ws){
        this.ws = ws;
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static Props props(WSClient ws) {
        return Props.create(SearchActor.class, ws);
    }

    @Override
    public void preStart() {
        log.info("SearchActor {}-{} started at ", this, LocalTime.now());
    }

    @Override
    public void postStop() {
        log.info("SearchActor {}-{} stopped at ", this, LocalTime.now());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.SearchPageActorMessage.class, this::searchProjectFromWS)
                .build();
    }

    private void searchProjectFromWS(Messages.SearchPageActorMessage searchPageActorQuery) {

        final ActorRef senderRef = sender();
        ws.url(baseURL + "/projects/0.1/projects/active")
                .addHeader("freelancer-oauth-v1", "l12Bz0qvwEkZVSvwzFds2EBSGGhDqa")
                .addQueryParameter("job_details", "true")
                .addQueryParameter("query", searchPageActorQuery.query)
                .addQueryParameter("limit", String.valueOf(SearchActor.RESULT_COUNT))
                .addQueryParameter("compact", "true").get().thenApplyAsync(WSResponse::asJson).toCompletableFuture()
                .thenApplyAsync(result -> {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

                    try {
                        APIResponse project = mapper.treeToValue(result, APIResponse.class);
                        SearchResult searchResult = new SearchResult();
                        searchResult.setQuery(searchPageActorQuery.query);
                        searchResult.setProjects(project.getResult().getProjects());

                        projects.add(0, searchResult);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }

                    return projects;
                })
        .thenAccept(response -> senderRef.tell((List<SearchResult>) response, self()));
    }

}
