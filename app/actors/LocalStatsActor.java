package actors;

/**
 * Local stats Actor
 * 
 * @author Darshak Kachchhi
 */

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import models.ProcessProjects;
import play.libs.ws.WSClient;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;

public class LocalStatsActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final WSClient ws;

    @Inject
    public LocalStatsActor(WSClient ws){
        this.ws = ws;
    }

    public static Props props(WSClient ws) {
        return Props.create(LocalStatsActor.class, ws);
    }

    @Override
    public void preStart() {
        log.info("LocalStatsActor {}-{} started at ", this, LocalTime.now());
    }

    @Override
    public void postStop() {
        log.info("LocalStatsActor {}-{} stopped at ", this, LocalTime.now());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.LocalStatsActorMessage.class, this::localStatsResult)
                .build();
    }

    private void localStatsResult(Messages.LocalStatsActorMessage localStatsActorMessage) {

        final ActorRef senderRef = sender();
        CompletableFuture.supplyAsync(( ) -> {
                    LinkedHashMap<String, Long> map =  ProcessProjects.getLocalStatByProjectId(SearchActor.projects, localStatsActorMessage.projectId);
                    LinkedHashMap<String, Long> mapProfile =  ProcessProjects.getLocalStatByProjectId(ProfileInfoActor.ProfileProjectsResults, localStatsActorMessage.projectId);
                    map.putAll(mapProfile);

                    LinkedHashMap<String, Long> mapSkills =  ProcessProjects.getLocalStatByProjectId(SearchSkillActor.skillSearchResults, localStatsActorMessage.projectId);
                    map.putAll(mapSkills);
                    return map;
                }).thenAccept(response -> senderRef.tell(response, self()));
    }
}
