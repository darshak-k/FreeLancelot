package models;

/**
 * StatusData test classes to test StatusData class
 * 
 * @author Apekshaba Gohil
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;
    
import models.StatusData;

public class StatusDataTest {

    @Test
    public void getEmail_varifiedTest() {
		StatusData data = new StatusData();
        data.setEmail_varified("True");

        assertEquals("True", data.getEmail_varified());
        
	}

    
}

