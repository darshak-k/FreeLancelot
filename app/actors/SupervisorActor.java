package actors;

/**
 * Supervisor Actor
 * 
 * @author Darshak Kachchhi, Mansi Lakhani, Apekshaba Gohil
 */

import akka.actor.*;
import akka.japi.pf.DeciderBuilder;
import play.libs.ws.WSClient;
import scala.concurrent.duration.Duration;

import javax.inject.Inject;
import java.io.InterruptedIOException;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;


import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.restart;

public class SupervisorActor extends AbstractActor {
    private final WSClient ws;

    @Inject
    public SupervisorActor(WSClient ws) {
        this.ws =  ws;
    }

    public static Props props(WSClient ws) {
        return Props.create(SupervisorActor.class, ws);
    }

    public static final OneForOneStrategy STRATEGYForHandlingException = new OneForOneStrategy(
            10,
            Duration.create("10 seconds"),
            DeciderBuilder
                    .match(InterruptedIOException.class, ex -> escalate())
                    .match(ActorInterruptedException.class, ex -> escalate())
                    .match(InterruptedException.class, ex -> escalate())
                    .match(ExecutionException.class, ex -> escalate())
                    .match(NullPointerException.class, ex -> restart())
                    .match(CompletionException.class, ex -> escalate())
                    .build());

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return STRATEGYForHandlingException;
    }

    @Override
    public Receive createReceive() {
        final ActorRef projectSearchChildActor = getContext().actorOf(SearchActor.props(ws));
        final ActorRef localStatsChildActor = getContext().actorOf(LocalStatsActor.props(ws));
        final ActorRef globalStatsChildActor = getContext().actorOf(GlobalStatsActor.props(ws));
        final ActorRef profileDataChildActor = getContext().actorOf(ProfileDataActor.props(ws));
        final ActorRef profileInfoChildActor = getContext().actorOf(ProfileInfoActor.props(ws));
        final ActorRef skillsSearchChildActor = getContext().actorOf(SearchSkillActor.props(ws));

        return receiveBuilder()
                .match(Messages.SearchPageActorMessage.class, any -> {
                    projectSearchChildActor.forward(any, getContext());
                })
                .match(Messages.LocalStatsActorMessage.class, any -> {
                    localStatsChildActor.forward(any, getContext());
                })
                .match(Messages.GlobalStatsActorMessage.class, any -> {
                    globalStatsChildActor.forward(any, getContext());
                })
                .match(Messages.ProfileDataActorMessage.class, any-> {
                    profileDataChildActor.forward(any, getContext());
                })
                .match(Messages.ProfileInfoActorMessage.class, any-> {
                    profileInfoChildActor.forward(any, getContext());
                })
                .match(Messages.SkillsSearchActorMessage.class, any -> {
                    skillsSearchChildActor.forward(any, getContext());
                })
                .build();
    }
}
