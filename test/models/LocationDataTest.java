package Models;
import models.*;


/**
 * Location data test classes to test LocationData class
 * 
 * @author Apekshaba Gohil
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;


public class LocationDataTest {

    @Test
    public void getCountryTest() {
		LocationData country = new LocationData();
        country.setCountry(new Country());

        assertEquals(0, String.valueOf(country.getCountry()));
        
	}

    
}
