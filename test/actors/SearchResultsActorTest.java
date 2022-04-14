package actors;

import  akka.testkit.javadsl.*;
import models.SearchResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import play.inject.Injector;
import akka.actor.ActorSystem;

import static org.junit.Assert.assertEquals;
import akka.actor.ActorRef;
import java.util.ArrayList;
import play.libs.ws.WSClient;

import javax.inject.Inject;

public class SearchResultsActorTest {
    static ActorSystem system;
    private Injector testApp;

    @Inject
    static WSClient ws;

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


//    @Test(expected=NullPointerException.class)
//    public void testSearchActorGreeting() {
//        final TestKit testProbe = new TestKit(system);
//        final ActorRef supervisor = system.actorOf(
//                SearchActor.props(ws));
//        supervisor.tell(new Messages.SearchPageActorMessage("java"), ActorRef.noSender());
//        ArrayList<SearchResult> response = testProbe.expectMsgClass(ArrayList.class);
//    }
}