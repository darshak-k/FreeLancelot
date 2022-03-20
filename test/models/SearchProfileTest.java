package models;

/**
 * SearchProfile test classes to test SearchProfile class
 * 
 * @author Apekshaba Gohil
 */


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

import java.util.ArrayList;


public class SearchProfileTest {

	@Test
	public void getQueryProjectsTest() {
		SearchProfile searchResult = new SearchProfile();
		searchResult.setQuery("1234");
		ProfileData p = new ProfileData();
		p.setId("12345");
		searchResult.setProfiledata(p);

		assertEquals("1234", searchResult.getQuery());
		assertEquals("12345", searchResult.getProfiledata().getId());
	}
    
}

