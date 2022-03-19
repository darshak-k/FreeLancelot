package models;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Process Project Data
 *
 * @author Darshak kachchhi
 * @created 16/03/22
 */
public class ProcessProjects {
	public static final long MAX_PROJECT_GLOBAL_STATS = 250;

	/**
	 * Count the frequency of each word and create a key-value pair of keyword and
	 * frequency after that sort the pairs by value then key and create a new
	 * <code>LinkedHashMap</code> of which storing all the values.
	 * 
	 * @param descriptionWordList list of all the keyword from the project
	 *                            description of fetched data from the API.
	 */
	private static LinkedHashMap<String, Long> sortedStatsOfLinkedHashMap(List<String> descriptionWordList) {
		LinkedHashMap<String, Long> map = descriptionWordList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

		return map;
	}

	/**
	 * Function to filter the project for given project id from the list of
	 * freelancer projects which are faced from the API call.
	 * 
	 * @param projects  list of the freelancer project which stores all the
	 *                  information about project such as owner id, preview
	 *                  description, submitted date, title, skills, project type
	 *                  etc.
	 * @param projectId project id to get project details
	 */
	public static Optional<FreelancerProject> getProjectByProjectId(List<FreelancerProject> projects,
			String projectId) {
		Optional<FreelancerProject> project = projects.stream().filter(p -> p.getId().equals(projectId)).limit(1)
				.findFirst();

		return project;
	}

	/**
	 * Get Search result from the list of all the search result by query
	 * 
	 * @param projects the list of search of result to find search result
	 * @param query    query for which we need to find search result
	 */
	public static Optional<SearchResult> getProjectByQuery(List<SearchResult> projects, String query) {
		Optional<SearchResult> result = projects.stream().filter(p -> p.getQuery().equals(query)).limit(1).findFirst();

		return result;
	}

	/**
	 * Get global stats of all the search result for the latest 250 projects
	 * 
	 * @param searchResultsData list of search result data from the API call
	 */
	public static LinkedHashMap<String, Long> getGlobalStats(List<SearchResult> searchResultsData) {
		List<FreelancerProject> resultData = searchResultsData.stream()
				.flatMap(project -> project.getProjects().stream()).limit(MAX_PROJECT_GLOBAL_STATS)
				.collect(Collectors.toList());

		List<String> descriptionWordList = resultData.stream()
				.flatMap(project -> Arrays.asList(project.getPreview_description().split("\\s+")).stream())
				.collect(Collectors.toList());

		return sortedStatsOfLinkedHashMap(descriptionWordList);

	}

	/**
	 * Get local stats (frequency of word of selected project) of given project id
	 * 
	 * @param searchResultsData list list of search result data from the API call
	 * @param projectId         the project id of the project for which local stats
	 *                          will be calculated
	 */
	public static LinkedHashMap<String, Long> getLocalStatByProjectId(List<SearchResult> searchResultsData,
			String projectId) {
		List<FreelancerProject> resultData = searchResultsData.stream().flatMap(result -> result.getProjects().stream())
				.collect(Collectors.toList());

		Optional<FreelancerProject> project = ProcessProjects.getProjectByProjectId(resultData, projectId);

		if (project.isPresent()) {
			List<String> descriptionWordList = Arrays.asList(project.get().getPreview_description().split("\\s+"));
			return sortedStatsOfLinkedHashMap(descriptionWordList);
		}
		return new LinkedHashMap<>();
	}

	/**
	 * Remove search result from the list of search project for the given query
	 * 
	 * @param projects the list of search of result to find search result
	 * @param query    query for which we need to find search result
	 */
	public static List<SearchResult> removeProjectResult(List<SearchResult> searchResults, String query) {
		return searchResults.stream().filter(search -> !search.getQuery().equals(query)).collect(Collectors.toList());
	}
}
