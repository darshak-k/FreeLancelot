package Models;
import models.*;


/**
 * Primary_currencyData test classes to test Primary_currencyData class
 * 
 * @author Apekshaba Gohil
 */


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;
    

public class Primary_currencyDataTest {
    
    @Test
    public void getNameTest() {
		Primary_currencyData name = new Primary_currencyData();
        name.setName("USDollar");

        assertEquals("USDollar", name.getName());
        
	}


}
