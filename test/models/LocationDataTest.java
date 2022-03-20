package models;


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
        ProfileData data = new ProfileData();
        Country c = new Country();
        c.setName("India");
        LocationData l = new LocationData();
        l.setCountry(c);
        data.setLocation(l);
        assertEquals("India", data.getLocation().getCountry().getName());

    }

    
}
