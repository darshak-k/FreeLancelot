package actors;

/**
 * Search Skills Actor
 * 
 * @author Apekshaba Gohil
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

public class SearchSkillActor extends AbstractActor{
    private final WSClient ws;
    public static List<SearchResult> skillSearchResults = new ArrayList<>();
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private static final int RESULT_COUNT = 10;
    private static String baseURL = "https://www.freelancer.com/api";
    private ObjectMapper mapper;

    @Inject
    public SearchSkillActor(WSClient ws){
        this.ws = ws;
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static Props props(WSClient ws) {
        return Props.create(SearchSkillActor.class, ws);
    }

    @Override
    public void preStart() {
        log.info("SearchSkillActor {}-{} started at ", this, LocalTime.now());
    }

    @Override
    public void postStop() {
        log.info("SearchSkillActor {}-{} stopped at ", this, LocalTime.now());
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.SkillsSearchActorMessage.class, this::searchProjectSkills)
                .build();
    }

    public void searchProjectSkills(Messages.SkillsSearchActorMessage searchSkillActorquery){
        final ActorRef senderRef = sender();

        ws.url(baseURL + "/projects/0.1/projects/active/")
				.addHeader("freelancer-oauth-v1", "l12Bz0qvwEkZVSvwzFds2EBSGGhDqa")
				.addQueryParameter("limit", "10")
				.addQueryParameter("jobs[]", String.valueOf(searchSkillActorquery.query))
				.addQueryParameter("job_details", "true")
				.addQueryParameter("compact", "true")
				.get()
				.thenApplyAsync(WSResponse::asJson)
				.toCompletableFuture()
				.thenApplyAsync(result -> {
					ObjectMapper mapper = new ObjectMapper();
					mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

					try {
						APIResponse project = mapper.treeToValue(result, APIResponse.class);
						SearchResult searchResult = new SearchResult();
						searchResult.setQuery(String.valueOf(searchSkillActorquery.query));
						searchResult.setProjects(project.getResult().getProjects());

						skillSearchResults.add(0, searchResult);
						// cache.set("cachedSkillsResult", skillSearchResults, 15 * 60);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					return skillSearchResults;

				})
                .thenAccept(response -> senderRef.tell((List<SearchResult>) response, self()));
    }
}
