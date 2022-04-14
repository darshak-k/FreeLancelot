package actors;

/**
 * SearchSkillActor test class to test SearchSkill Actor class
 *
 * @author Mansi Lakhani
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

public class SearchSkillActorTest {
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


    @Test
    public void testSearchSkillActor() {
        final TestKit testProbe = new TestKit(system);
        final ActorRef supervisor = system.actorOf(
                SearchActor.props(ws));
        supervisor.tell(new Messages.SkillsSearchActorMessage(1234), ActorRef.noSender());
        ArrayList<SearchResult> response = testProbe.expectMsgClass(ArrayList.class);
    }

}
