package Models;


/**
 * ProfileResponce test classes to test ProfilResponce class
 * 
 * @author Apekshaba Gohil
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class ProfileResponceTest {
    
    @Test
	public void getDataTest() {

		ProfileResponce responce = new ProfileResponce();
		responce.setStatus("True");
        responce.setRequest_id("1234567");
        responce.setProfileResult(new ProfileResultData());

		assertEquals("True", responce.getStatus());
        assertEquals("1234567", responce.getRequest_id());
        assertEquals(0, String.valueOf(responce.getProfileResult()));


    }



}
