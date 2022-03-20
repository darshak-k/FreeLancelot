package models;


/**
 * ProfileResponce test classes to test ProfilResponce class
 * 
 * @author Apekshaba Gohil
 */

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class ProfileResponceTest {

    @Test
    public void statusTest() {
        ProfileResponce apiResponse = new ProfileResponce();
        apiResponse.setStatus("true");

        assertEquals("true", apiResponse.getStatus());
    }

    @Test
    public void request_idTest() {
        ProfileResponce apiResponse = new ProfileResponce();
        apiResponse.setRequest_id("717adaef5ff784e8b36c96840c578aec");

        assertEquals("717adaef5ff784e8b36c96840c578aec", apiResponse.getRequest_id());
    }
    
    @Test
	public void getDataTest() {

		ProfileResponce responce = new ProfileResponce();
        ProfileData data = new ProfileData();

        data.setId("24304119");
        assertEquals("24304119", data.getId());
        responce.setResult(data);

        assertEquals("24304119", responce.getResult().getId());

    }

    @Test
    public void testToString()
    {
        ProfileResponce apiResponse = new ProfileResponce();
        ProfileData res = new ProfileData();
        apiResponse.setRequest_id("717adaef5ff784e8b36c96840c578aec");
        apiResponse.setStatus("true");
        String expected = "APIResponceWrap [status=true request_id=717adaef5ff784e8b36c96840c578aec result=" + res + "]";
        apiResponse.toString();
    }


}
