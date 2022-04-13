package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import models.ProcessProjects;
import play.libs.ws.WSClient;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class GlobalStatsActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final WSClient ws;

    @Inject
    public GlobalStatsActor(WSClient ws){
        this.ws = ws;
    }

    public static Props props(WSClient ws) {
        return Props.create(GlobalStatsActor.class, ws);
    }

    @Override
    public void preStart() {
        log.info("GlobalStatsActor {}-{} started at ", this, LocalTime.now());
    }

    @Override
    public void postStop() {
        log.info("GlobalStatsActor {}-{} stopped at ", this, LocalTime.now());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Messages.GlobalStatsActorMessage.class, this::globalStatsResult)
                .build();
    }

    private void globalStatsResult(Messages.GlobalStatsActorMessage globalStatsActorMessage) {

        final ActorRef senderRef = sender();
        CompletableFuture.supplyAsync(( ) -> {
            return ProcessProjects.getGlobalStats(SearchActor.projects);
        }).thenAccept(response -> senderRef.tell(response, self()));
    }

}
