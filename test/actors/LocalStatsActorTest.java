package actors;

/**
 * LocalStatsActor test class to test LocalStatsActor
 *
 * @author Darshak Kachchhi
 */

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import play.inject.Injector;
import play.libs.ws.WSClient;

import javax.inject.Inject;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class LocalStatsActorTest {
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


	@Test
	public void testLocalStatsActor() {
		final TestKit testProbe = new TestKit(system);
		final ActorRef supervisor = system.actorOf(
				SupervisorActor.props(ws));
		supervisor.tell(new Messages.LocalStatsActorMessage("12345"), ActorRef.noSender());
		LinkedHashMap<String, Long> response = testProbe.expectMsgClass(LinkedHashMap.class);
		assertEquals(response.size(), 0);
	}
}
