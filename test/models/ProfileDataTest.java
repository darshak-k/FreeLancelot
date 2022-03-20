package Models;
import models.*;

/**
 * ProfilData test classes to test ProfileData class
 * 
 * @author Apekshaba Gohil
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;



public class ProfileDataTest {
    
    @Test
	public void getDataTest() {

        

		ProfileData data = new ProfileData();
		data.setId("24304119");
        data.setUsername("korjon");
        data.setDisplayname("korjon");
        data.setRole("developer");
        data.setRegistrationdate("Java");
        data.setChosenrole("developer");
        data.setLimitedaccount("Java");
        data.setLocation(new LocationData());
        data.setStatus(new StatusData());
        data.setPrimary_currency(new Primary_currencyData());




		assertEquals("24304119", data.getId());
        assertEquals("korjon", data.getUsername());
        assertEquals("korjon", data.getDisplayname());
        assertEquals("developer", data.getRole());
        assertEquals("Java", data.getRegistrationdate());
        assertEquals("developer", data.getChosenrole());
        assertEquals("Java", data.getLimitedaccount());
        assertEquals(0, String.valueOf(data.getLocation()));
        assertEquals(0, String.valueOf(data.getStatus()));
        assertEquals(0, String.valueOf(data.getPrimary_currency()));
	}


}
