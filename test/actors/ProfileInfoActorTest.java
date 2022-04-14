package actors;

/**
 * ProfileInfoActor test class to test ProfileInfo Actor class
 *
 * @author Apekshaba Gohil
 */


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import models.SearchResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import play.inject.Injector;
import play.libs.ws.WSClient;

import javax.inject.Inject;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProfileInfoActorTest {
    static ActorSystem system;
    private Injector testApp;

    @Inject
    WSClient ws;

    /**
     * Setup the tests
     */
    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    /**
     * Shut down system
     */
    @AfterClass
    public static void teardown() {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

//    @Test
//	public void testProfileInfoActor() {
//        final TestKit testProbe = new TestKit(system);
//        final ActorRef supervisor = system.actorOf(
//                SupervisorActor.props(ws));
//        supervisor.tell(new Messages.ProfileInfoActorMessage(12345), ActorRef.noSender());
//        ArrayList<SearchResult> response = testProbe.expectMsgClass(ArrayList.class);
//        assertEquals(response.size(), 0);
//    }

}
