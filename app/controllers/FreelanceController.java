package controllers;

import actors.Messages;
import static akka.pattern.Patterns.ask;

import actors.SupervisorActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import models.SearchResult;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.compat.java8.FutureConverters;
import views.html.index;
import views.html.stats;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class FreelanceController  extends Controller {
    @Inject
    private Materializer materializer;

    final ActorRef supervisorActor;
    public static WSClient ws;

    @Inject
    public FreelanceController(WSClient ws, Materializer materializer, ActorSystem actorSystem) {
        this.materializer=materializer;

        supervisorActor = actorSystem.actorOf(SupervisorActor.props(ws), "SupervisorActor");
    }

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


    public CompletionStage<Result> localStats(String projectID) {
        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.LocalStatsActorMessage(projectID),
                        5000))
                .thenApplyAsync(response -> {
                    return ok(stats.render("local", (LinkedHashMap<String, Long>) response));
                }).toCompletableFuture();
    }

    public CompletionStage<Result> globalStats() {
        return FutureConverters
                .toJava(ask(supervisorActor,
                        new Messages.GlobalStatsActorMessage(),
                        5000))
                .thenApplyAsync(response -> {
                    return ok(stats.render("global", (LinkedHashMap<String, Long>) response));
                }).toCompletableFuture();
    }

}
