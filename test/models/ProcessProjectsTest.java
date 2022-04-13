package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ProcessProjectsTest {
	@Test
	public void testRemoveProject() {
		List<SearchResult> searchResults = new ArrayList<>();
		SearchResult search = new SearchResult();
		search.setQuery("java");
		search.setProjects(new ArrayList<>());
		searchResults.add(search);

		assertEquals(1, searchResults.size());
		searchResults = ProcessProjects.removeProjectResult(searchResults, "java");
		assertEquals(0, searchResults.size());
	}

	@Test
	public void testGetProjectByQuery() {
		List<SearchResult> searchResults = new ArrayList<>();
		SearchResult search = new SearchResult();
		search.setQuery("java");

		FreelancerProject project = new FreelancerProject();
		project.setId("111111");
		project.setPreview_description("Java doc");

		ArrayList<FreelancerProject> projects = new ArrayList<>();
		projects.add(project);
		search.setProjects(projects);
		searchResults.add(search);

		assertEquals(1, searchResults.size());
		Optional<SearchResult> result = ProcessProjects.getProjectByQuery(searchResults, "java");
		assertTrue(result.isPresent());

		result = ProcessProjects.getProjectByQuery(searchResults, "python");
		assertFalse(result.isPresent());
	}

	@Test
	public void testGetLocalStatByProject() {
		List<SearchResult> searchResults = new ArrayList<>();
		SearchResult search = new SearchResult();
		search.setQuery("java");

		FreelancerProject project = new FreelancerProject();
		project.setId("111111");
		project.setPreview_description("Java doc");

		ArrayList<FreelancerProject> projects = new ArrayList<>();
		projects.add(project);
		search.setProjects(projects);
		searchResults.add(search);

		assertEquals(1, searchResults.size());
		LinkedHashMap<String, Long> result = ProcessProjects.getLocalStatByProjectId(searchResults, "111111");
		assertTrue(result.size() > 0);

		result = ProcessProjects.getLocalStatByProjectId(searchResults, "222222");
		assertFalse(result.size() > 0);
	}
}
