package controllers;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import models.ProcessProjects;
import org.junit.*;
import play.cache.NamedCache;
import play.cache.SyncCacheApi;
import play.libs.ws.*;
import play.mvc.Http;
import play.mvc.Result;
import play.routing.RoutingDsl;
import play.server.Server;
import play.test.Helpers;
import play.test.WSTestClient;
import play.test.WithBrowser;


import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.twirl.api.Content;
import views.html.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;

import static play.mvc.Http.Status.NOT_FOUND;
import static play.mvc.Results.*;
import static play.test.Helpers.*;

public class FreelancerControllerTest  extends WithBrowser {
    private FreelancerController client;
    private WSClient ws;
    private Server server;

    @NamedCache("session-cache")
    private SyncCacheApi cache;

    @Before
    public void setup() {
        server = Server.forRouter((components) ->
                RoutingDsl.fromComponents(components)
                        .GET("/search")
                        .routingTo( request -> {
                            System.out.println("SEARCH "+request);
                            return ok().sendResource("controllers/searchSkills.json");
                        }).GET("/skills")
                        .routingTo( request -> {
                            return ok().sendResource("controllers/searchSkills.json");
                        })
                        .build());
        ws = WSTestClient.newClient(server.httpPort());
        cache = new TempSyncCacheSPI();
        client = new FreelancerController(ws, cache);
    }

    @After
    public void tearDown() throws IOException {
        try {
            ws.close();
        } finally {
            server.stop();
        }
    }

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void testLocalAndGlobalStats() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/search");
        Result result = client.localStats("33255305");
        assertEquals(OK, result.status());

        result = client.globalStats();
        assertEquals(OK, result.status());

        result = client.localStats("33255305");
        assertEquals(OK, result.status());
    }

    @Test
    public void testProfiles() {
        Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/profile:27127619");
        CompletionStage<Result> result = client.profile(Integer.getInteger("27127619"));
//        assertEquals(OK, result.status());
    }

    @Test
    public void testSearchProjects() {
        Content html = index.render(new ArrayList<>());
        assertThat("text/html", is(html.contentType()));
    }

    @Test
    public void testBadRoute() {
        Http.RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/xx/Kiwi");

        Result result = route(app, request);
        assertEquals(NOT_FOUND, result.status());
    }
}