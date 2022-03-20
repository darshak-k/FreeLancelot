package controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.*;

import play.cache.NamedCache;
import play.cache.SyncCacheApi;

import play.libs.ws.WSResponse;
import play.libs.concurrent.HttpExecutionContext;

import play.mvc.Controller;
import play.mvc.Result;

import play.libs.ws.WSClient;
import play.mvc.Http;
import java.util.UUID;

import models.FreelancerProject;
import views.html.*;

import javax.inject.Inject;

/**
 * Freelancer controller class
 * 
 * @author Darshak Kachchhi, Mansi Lakhani and Apekshaba Gohil
 *
 */
public class FreelancerController extends Controller {

	private WSClient ws;
	private HttpExecutionContext httpExecutionContext;

	@NamedCache("session-cache")
	private SyncCacheApi cache;

	private String baseURL = "https://www.freelancer.com/api";
	private List<FreelancerProject> projects = new ArrayList<FreelancerProject>();
	private List<SearchResult> searchResults = new ArrayList<SearchResult>();
	private List<SearchResult> skillSearchResults = new ArrayList<SearchResult>();
	private List<SearchResult> ProfileProjectsResults = new ArrayList<SearchResult>();
	private List<SearchProfile> ProfileResults = new ArrayList<SearchProfile>();
	private static final int RESULT_COUNT = 10;

	@Inject
	public FreelancerController(WSClient ws, SyncCacheApi cache, HttpExecutionContext ec) {
		this.ws = ws;
		this.cache = cache;
		this.httpExecutionContext = ec;
	}

	/**
	 * Freelancer API call to fetch data from the API and render into the html page.
	 * API data will be fetch as a JSON Data and then using the ObjectMapper,
	 * convert the data into data model of application.
	 * 
	 * @author Mansi Lakhani
	 * @param skillId fetch result for given skill id
	 */
	public CompletionStage<Result> fetchProjectsFromSkills(Integer skillId) {
		Optional<List<SearchResult>> cachedSkillsResults = cache.get("cachedSkillsResult");
		if (cachedSkillsResults.isPresent()) {
			searchResults = cachedSkillsResults.get();
			Optional<SearchResult> previousSearchOption = ProcessProjects.getProjectByQuery(searchResults,
					String.valueOf(skillId));
			if (previousSearchOption.isPresent()) {
				SearchResult previousSearch = previousSearchOption.get();
				searchResults = ProcessProjects.removeProjectResult(searchResults, String.valueOf(skillId));
				searchResults.add(0, previousSearch);
				return CompletableFuture.completedFuture(ok(index.render(searchResults)));
			}

		}

		return ws.url(baseURL + "/projects/0.1/projects/active/")
				.addHeader("freelancer-oauth-v1", "l12Bz0qvwEkZVSvwzFds2EBSGGhDqa")
				.addQueryParameter("limit", "10")
				.addQueryParameter("jobs[]", String.valueOf(skillId))
				.addQueryParameter("job_details", "true")
				.addQueryParameter("compact", "true")
				.get()
				.thenApplyAsync(WSResponse::asJson)
				.toCompletableFuture()
				.thenApplyAsync(result -> {
					System.out.println("Data..." + result);
					ObjectMapper mapper = new ObjectMapper();
					mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

					try {
						APIResponse project = mapper.treeToValue(result, APIResponse.class);
						SearchResult searchResult = new SearchResult();
						searchResult.setQuery(String.valueOf(skillId));
						searchResult.setProjects(project.getResult().getProjects());

						skillSearchResults.add(0, searchResult);
						cache.set("cachedSkillsResult", skillSearchResults, 15 * 60);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					return ok(index.render(skillSearchResults)).withNewSession();

				});
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
	public Result globalStats() {
		LinkedHashMap<String, Long> map = ProcessProjects.getGlobalStats(searchResults);
		return ok(stats.render("global", map));
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
	public Result localStats(String projectID) {
		LinkedHashMap<String, Long> map = ProcessProjects.getLocalStatByProjectId(searchResults, projectID);
		return ok(stats.render("local", map));
	}

	/**
	 * Freelancer API call to fetch data from the API and render into the html page.
	 * API data will be fetch as a JSON Data and then using the ObjectMapper,
	 * convert the data into data model of application.
	 * 
	 * @author Mansi Lakhani
	 * @param skillId fetch result for given skill id
	 */
	public CompletionStage<Result> skills(Integer skillId) {
		return fetchProjectsFromSkills(skillId);
	}

	/**
	 * Freelancer API call to fetch data from the API and render into the html page.
	 * API data will be fetch as a JSON Data and then using the ObjectMapper,
	 * convert the data into data model of application.
	 * 
	 * @author Darshak Kachchhi, Mansi Lakhani
	 * @param inputKeyword fetch result for given keyword
	 */
	private CompletionStage<Result> fetchData(String inputKeyword) {

		Optional<List<SearchResult>> cachedSearchResults = cache.get("cachedSearchResults");
		if (cachedSearchResults.isPresent()) {
			searchResults = cachedSearchResults.get();
			Optional<SearchResult> previousSearchOption = ProcessProjects.getProjectByQuery(searchResults,
					inputKeyword);
			if (previousSearchOption.isPresent()) {
				SearchResult previousSearch = previousSearchOption.get();
				searchResults = ProcessProjects.removeProjectResult(searchResults, inputKeyword);
				searchResults.add(0, previousSearch);
				return CompletableFuture.completedFuture(ok(index.render(searchResults)));
			}

		}

		return ws.url(baseURL + "/projects/0.1/projects/active")
				.addHeader("freelancer-oauth-v1", "l12Bz0qvwEkZVSvwzFds2EBSGGhDqa")
				.addQueryParameter("job_details", "true").addQueryParameter("query", inputKeyword)
				.addQueryParameter("limit", String.valueOf(FreelancerController.RESULT_COUNT))
				.addQueryParameter("compact", "true").get().thenApplyAsync(WSResponse::asJson).toCompletableFuture()
				.thenApplyAsync(result -> {
					ObjectMapper mapper = new ObjectMapper();
					mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

					try {
						APIResponse project = mapper.treeToValue(result, APIResponse.class);
						SearchResult searchResult = new SearchResult();
						searchResult.setQuery(inputKeyword);
						searchResult.setProjects(project.getResult().getProjects());

						searchResults.add(0, searchResult);

						cache.set("cachedSearchResults", searchResults, 15 * 60);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					return ok(index.render(searchResults));
				});
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
	 * @return
	 */
	public CompletionStage<Result> search(String inputKeyword) {
		return fetchData(inputKeyword);
	}

	/**
	 * An action that renders an HTML page with a welcome message. The configuration
	 * in the <code>routes</code> file means that this method will be called when
	 * the application receives a <code>GET</code> request with a path of
	 * <code>/</code>.
	 * * @author Mansi Lakhani
	 */
	public CompletionStage<Result> index(Http.Request request) {
		searchResults.clear();
		String sessionId = request.session().get("SESSION_ID").orElseGet(() -> UUID.randomUUID().toString());
		return CompletableFuture
				.completedFuture(ok(index.render(searchResults)).addingToSession(request, "SESSION_ID", sessionId));
	}

	/**
	 * Freelancer API call to fetch data from the API and render into the html page.
	 * API data will be fetch as a JSON Data and then using the ObjectMapper,
	 * convert the data into data model of application.
	 * 
	 * @author Apekshaba Gohil
	 * @param ownerID fetch result for given owner id
	 */
	public CompletionStage<Result> fetchOwnerProject(Integer ownerID) {

		return ws.url(baseURL + "/projects/0.1/projects?owners[]=" + String.valueOf(ownerID))
				.addHeader("freelancer-oauth-v1", "l12Bz0qvwEkZVSvwzFds2EBSGGhDqa")
				.addQueryParameter("job_details", "true")
				.addQueryParameter("query", String.valueOf(ownerID))
				.addQueryParameter("limit", String.valueOf(RESULT_COUNT))
				.get()
				.thenApplyAsync(WSResponse::asJson)
				.toCompletableFuture()
				.thenApplyAsync(result -> {
					ObjectMapper mapper = new ObjectMapper();
					mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

					try {
						APIResponse project = mapper.treeToValue(result, APIResponse.class);
						SearchResult searchResult = new SearchResult();
						searchResult.setQuery(String.valueOf(ownerID));
						searchResult.setProjects(project.getResult().getProjects());

						ProfileProjectsResults.add(0, searchResult);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					return ok(profile.render(ProfileProjectsResults, ProfileResults));

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
	public CompletionStage<Result> profile(Integer ownerID) {
		return fetchOwnerProject(ownerID);

	}

	/**
	 * Freelancer API call to fetch data from the API and render into the html page.
	 * API data will be fetch as a JSON Data and then using the ObjectMapper,
	 * convert the data into data model of application.
	 * 
	 * @author Apekshaba Gohil
	 * @param ownerID fetch result for given owner id
	 */
	public CompletionStage<Result> profileData(Integer ownerID) {
		ProfileProjectsResults.clear();
		ProfileResults.clear();

		return ws.url(baseURL + "/users/0.1/users/" + String.valueOf(ownerID))
				.addHeader("freelancer-oauth-v1", "l12Bz0qvwEkZVSvwzFds2EBSGGhDqa")
				.addQueryParameter("chosenrole", "true")
				.addQueryParameter("limitedaccount", "true")
				.addQueryParameter("query", String.valueOf(ownerID))
				.addQueryParameter("limit", String.valueOf(RESULT_COUNT))
				.addQueryParameter("compact", "true")
				.get()
				.thenApplyAsync(WSResponse::asJson)
				.toCompletableFuture()
				.thenApplyAsync(result1 -> {
					System.out.println("res..." + result1);
					ObjectMapper mapper = new ObjectMapper();
					mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

					try {
						ProfileResponce profile = mapper.treeToValue(result1, ProfileResponce.class);
						SearchProfile searchProfile = new SearchProfile();
						searchProfile.setQuery(String.valueOf(ownerID));
						searchProfile.setProfiledata(profile.getResult());

						ProfileResults.add(0, searchProfile);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					return redirect("/profile/" + ownerID);
				}, httpExecutionContext.current()).toCompletableFuture();

	}

}
