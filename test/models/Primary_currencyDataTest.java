package models;


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
        ProfileData data = new ProfileData();
        Primary_currencyData p = new Primary_currencyData();
        p.setName("EUR");
        data.setPrimary_currency(p);
        assertEquals("EUR", data.getPrimary_currency().getName());

    }


}
