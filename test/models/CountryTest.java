package Models;
import models.*;


/**
 * Country data test classes to test Country class
 * 
 * @author Apekshaba Gohil
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.*;


public class CountryTest {
    
    @Test
    public void getNameTest() {
		Country country = new Country();
        country.setName("USA");

        assertEquals("USA", country.getName());
        
	}


}
