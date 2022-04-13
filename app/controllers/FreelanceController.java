package controllers;

import actors.Messages;
import static akka.pattern.Patterns.ask;

import actors.SupervisorActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import models.SearchProfile;
import models.SearchResult;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.compat.java8.FutureConverters;
import views.html.index;
import views.html.profile;
import views.html.stats;

import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class FreelanceController extends Controller {
    @Inject
    private Materializer materializer;

    private List<SearchResult> ProfileProjectsResults = new ArrayList<SearchResult>();
    public List<SearchProfile> ProfileResults = new ArrayList<SearchProfile>();

    final ActorRef supervisorActor;
    public static WSClient ws;

    @Inject
    public FreelanceController(WSClient ws, Materializer materializer, ActorSystem actorSystem) {
        this.materializer = materializer;

        supervisorActor = actorSystem.actorOf(SupervisorActor.props(ws), "SupervisorActor");
    }

    /**
     * An action that renders an HTML page with a welcome message. The configuration
     * in the <code>routes</code> file means that this method will be called when
     * the application receives a <code>GET</code> request with a path of
     * <code>/</code>.
     *
     * @param request HTTP Request for index
     * @author Mansi Lakhani
     */
    public Result index(Http.Request request) {
        List<SearchResult> r = new ArrayList<>();
        return ok(index.render(r));
    }

    /**
     * An action that renders an HTML page with 10 latest projects of given keyword
     * and it will be rendered on the top of the previous result of projects. The
     * configuration in the <code>routes</code> file means that this method will be
     * called when the application receives a <code>GET</code> request with a path
     * of <code>/search/:inputKeyword</code>.
     *
     * @author Darshak Kachchhi, Mansi Lakhani
     * @param inputKeyword fetch result for given keyword which is entered by the
     *                     user into text box
     *
     * @return Result of search URI
     */
    public CompletionStage<Result> search(String inputKeyword) {
        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.SearchPageActorMessage(inputKeyword),
                        5000))
                .thenApplyAsync(response -> {
                    return ok(index
                            .render((List<SearchResult>) response));
                }).toCompletableFuture();
    }

    /**
     * An action that renders an HTML page with a local stats page of selected
     * project. The configuration in the <code>routes</code> file means that this
     * method will be called when the application receives a <code>GET</code>
     * request with a path of <code>/localstats</code>.
     * 
     * @author Darshak Kachchhi
     * 
     * @param projectID Local stats of projectID to print
     * @return Result of global states to render the result on HTML page.
     */
    public CompletionStage<Result> localStats(String projectID) {
        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.LocalStatsActorMessage(projectID),
                        5000))
                .thenApplyAsync(response -> {
                    return ok(stats.render("local", (LinkedHashMap<String, Long>) response));
                }).toCompletableFuture();
    }

    /**
     * An action that renders an HTML page with a Global stats page of latest 250
     * projects from all the search has beed made till now. The configuration in the
     * <code>routes</code> file means that this method will be called when the
     * application receives a <code>GET</code> request with a path of
     * <code>/globalstats</code>.
     * 
     * @author Darshak Kachchhi
     * 
     * @return Result of global states to render the result on HTML page.
     */
    public CompletionStage<Result> globalStats() {
        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.GlobalStatsActorMessage(),
                        5000))
                .thenApplyAsync(response -> {
                    return ok(stats.render("global", (LinkedHashMap<String, Long>) response));
                }).toCompletableFuture();
    }

    /**
     * An action that renders an HTML page with 10 latest projects of given skill
     * and it will be rendered on the top of the previous result of projects. The
     * configuration in the <code>routes</code> file means that this method will be
     * called when the application receives a <code>GET</code> request with a path
     * of <code>/skills/:skillId</code>.
     *
     * @author Mansi Lakhani
     * @param inputKeyword fetch result for given skill which is entered by the
     *                     user into text box
     *
     * @return Result of search URI
     */
    public CompletionStage<Result> skills(int inputKeyword) {
        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.SkillsSearchActorMessage(inputKeyword),
                        5000))
                .thenApplyAsync(response -> {
                    return ok(index.render((List<SearchResult>) response));
                }).toCompletableFuture();
    }

    /**
     * Freelancer API call to fetch data from the API and render into the html page.
     * API data will be fetch as a JSON Data and then using the ObjectMapper,
     * convert the data into data model of application.
     * 
     * @author Apekshaba Gohil
     * @param ownerID fetch result for given owner id
     */
    public CompletionStage<Result> profileData(Integer ownerId) {
        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.ProfileDataActorMessage(ownerId),
                        5000))
                .thenApplyAsync(response -> {
                    ProfileResults = (List<SearchProfile>) response;

                    return redirect("/profile/" + ownerId);
                }).toCompletableFuture();
    }

    /**
     * Freelancer API call to fetch data from the API and render into the html page.
     * API data will be fetch as a JSON Data and then using the ObjectMapper,
     * convert the data into data model of application.
     * 
     * @author Apekshaba Gohil
     * @param ownerID fetch result for given owner id
     */
    public CompletionStage<Result> profile(Integer ownerId) {

        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.ProfileInfoActorMessage(ownerId),
                        5000))
                .thenApplyAsync(response -> {
                    ProfileProjectsResults = (List<SearchResult>) response;
                    return ok(profile.render((List<SearchResult>) ProfileProjectsResults,
                            (List<SearchProfile>) ProfileResults));
                }).toCompletableFuture();
    }

}
