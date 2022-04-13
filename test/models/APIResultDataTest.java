package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * API Result Data class to test APIResultData class
 *
 * @author Mansi Lakhani
 */
public class APIResultDataTest {
    @Test
    public void resultCountTest() {

        APIResultData resultData = new APIResultData();
        resultData.setCount(0);

        assertEquals(0, resultData.getCount());
    }

    @Test
    public void resultProjectsTest() {

        APIResultData resultData = new APIResultData();
        List<FreelancerProject> projects = new ArrayList<FreelancerProject>();
        resultData.setProjects(projects);

        assertEquals(0, resultData.getProjects().size());
    }

    @Test
    public void ConstructorTest() {

        APIResultData resultData = new APIResultData(new ArrayList<FreelancerProject>(), 0);

        assertEquals(0, resultData.getCount());
        assertEquals(0, resultData.getProjects().size());
    }
}
