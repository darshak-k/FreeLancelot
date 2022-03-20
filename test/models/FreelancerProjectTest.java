package models;

import org.junit.Test;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * project data Test class to test FreelancerProject class
 *
 * @author Mansi Lakhani
 */
public class FreelancerProjectTest {

    @Test
    public void idTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setId("1");

        assertEquals("1", freelancerProject.getId());
    }

    @Test
    public void owner_idTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setOwner_id("1");

        assertEquals("1", freelancerProject.getOwner_id());
    }

    @Test
    public void titleTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setTitle("1");

        assertEquals("1", freelancerProject.getTitle());
    }

    @Test
    public void statusTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setStatus("true");

        assertEquals("true", freelancerProject.getStatus());
    }

    @Test
    public void preview_descriptionTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setPreview_description("Test");

        assertEquals("Test", freelancerProject.getPreview_description());
    }

    @Test
    public void seo_urlTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setSeo_url("mysql");

        assertEquals("mysql", freelancerProject.getSeo_url());
    }

    @Test
    public void typeTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setType("fixed");

        assertEquals("fixed", freelancerProject.getType());
    }

    @Test
    public void submit_dateTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setSubmitdate(1647745480);
        Date d = new Date(freelancerProject.getSubmitdate() * 1_000L);
        assertEquals(d, freelancerProject.getSubmit_date());
    }

    @Test
    public void submitdateTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setSubmitdate(1647745480);

        assertEquals(1647745480, freelancerProject.getSubmitdate());
    }

    @Test
    public void date_stringTest() {
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setSubmitdate(1647745480);
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        String date_string = df.format(freelancerProject.getSubmit_date());
        freelancerProject.setDate_string(date_string);
        assertEquals(date_string, freelancerProject.getDate_string());
    }

    @Test
    public void jobsTest(){
        List<JobData> jobData = new ArrayList<JobData> ();
        JobData job = new JobData();
        job.setId(1);
        job.setName("PHP");
        jobData.add(0, job);
        FreelancerProject freelancerProject = new FreelancerProject();
        freelancerProject.setJobs(jobData);

        assertEquals(1, freelancerProject.getJobs().size());
        assertEquals(1, freelancerProject.getJobs().get(0).getId());
        assertEquals("PHP", freelancerProject.getJobs().get(0).getName());
    }
}
