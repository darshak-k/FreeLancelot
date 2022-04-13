package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Search result Test class to test Search Result class
 * 
 * @author Darshak Kachchhi
 */
public class SearchResultTest {

	@Test
	public void getQueryProjectsTest() {
		SearchResult searchResult = new SearchResult();
		searchResult.setQuery("Java");
		searchResult.setProjects(new ArrayList<FreelancerProject>());
		
		assertEquals("Java", searchResult.getQuery());
		assertEquals(0, searchResult.getProjects().size());
	}

}
