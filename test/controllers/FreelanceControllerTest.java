
package controllers;

        import actors.Messages;
        import junit.framework.TestCase;
        import models.SearchResult;
        import net.sf.ehcache.CacheManager;
        import org.junit.Before;
        import org.junit.Test;
        import play.Application;
        import play.mvc.Http;
        import play.mvc.Result;
        import play.test.Helpers;

        import java.util.ArrayList;
        import java.util.List;

        import static play.mvc.Http.Status.OK;
        import static play.test.Helpers.GET;
        import static play.test.Helpers.route;

/**
 * @author Darshak Kachchhi , Mansi Lakhani , Apekshaba Gohil
 */
public class FreelanceControllerTest extends TestCase {

    public static Application app;
    List<SearchResult> result_map;
    Http.RequestBuilder request;
    FreelanceController controller;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        app = Helpers.fakeApplication();
        Helpers.start(app);
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/");
        Result result = route(app, request);
        assertEquals(OK, result.status());
        if(CacheManager.getInstance().cacheExists("play")){
            CacheManager.getInstance().shutdown();
        }
    }

    @Test
    public void testShowData() {
        Http.RequestBuilder request1 = new Http.RequestBuilder().method(GET).uri("/search?inputKeyword=java");
        result_map = new ArrayList<>();
        Result result = route(app, request1);
        assertEquals(OK, result.status());
    }

    @Test
    public void testGetSkills() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/skills/7");
        Result result = route(app, request);
        assertEquals(200, result.status());
    }

    @Test
    public void testGetProfileInfo(){
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/profile/61704285");
        Result result = route(app, request);
        assertEquals(200, result.status());
    }

    @Test
    public void testGetProfileDataInfo(){
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/profiledata/61704285");
        Result result = route(app, request);
        assertEquals(303, result.status());
    }

    @Test
    public void testLocalStats(){
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/localStats/33453216");
        Result result = route(app, request);
        assertEquals(200, result.status());
    }

    @Test
    public void testGlobalStats(){
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/globalStats");
        Result result = route(app, request);
        assertEquals(200, result.status());
    }

    @Test
    public void testSocket(){
        Messages msg = new Messages();
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/ws?inputKeyword=java");
        Result result = route(app, request);
    }
}