package models;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Api response Test class to test APIResponse class
 * 
 * @author Mansi Lakhani
 */
public class APIResponseTest {

    @Test
    public void statusTest() {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus("true");

        assertEquals("true", apiResponse.getStatus());
    }

    @Test
    public void request_idTest() {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setRequest_id("717adaef5ff784e8b36c96840c578aec");

        assertEquals("717adaef5ff784e8b36c96840c578aec", apiResponse.getRequest_id());
    }

    @Test
    public void resultCountTest() {

        APIResultData resultData = new APIResultData();
        resultData.setCount(0);

        assertEquals(0, resultData.getCount());
    }

    @Test
    public void resultProjectsTest() {
        APIResponse apiResponse = new APIResponse();
        List<FreelancerProject> projects = new ArrayList<FreelancerProject>();

        APIResultData resultData = new APIResultData(projects, 0);
        apiResponse.setResult(resultData);
        resultData.setProjects(projects);

        assertEquals(0, apiResponse.getResult().getProjects().size());
        assertEquals(0, apiResponse.getResult().getCount());
    }


    @Test
    public void testToString()
    {
        APIResponse apiResponse = new APIResponse();
        APIResultData res = new APIResultData();
        apiResponse.setRequest_id("717adaef5ff784e8b36c96840c578aec");
        apiResponse.setStatus("true");
        String expected = "APIResponceWrap [status=true request_id=717adaef5ff784e8b36c96840c578aec result=" + res + "]";
        apiResponse.toString();
    }



}
