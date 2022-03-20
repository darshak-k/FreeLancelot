package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProcessProjectsTest {

	@Test
	public void testRemoveProject() {
		List<SearchResult> searchResults = new ArrayList<>();
		SearchResult search = new SearchResult();
		search.setQuery("java");
		search.setProjects(new ArrayList<>());
		searchResults.add(search);
	}

}
