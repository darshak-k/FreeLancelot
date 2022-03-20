package Models;
import models.*;

/**
 * SearchProfile test classes to test SearchProfile class
 * 
 * @author Apekshaba Gohil
 */


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;


public class SearchProfileTest {

    @Test
    public void getQueryProfiledataTest() {
		SearchProfile searchProfile = new SearchProfile();
		searchProfile.setQuery("Java");
	    searchProfile.setProfiledata(new ProfileData());
		
		
		assertEquals("Java", searchProfile.getQuery());
	    assertEquals(0, String.valueOf(searchProfile.getProfiledata()));
	}

    
}

