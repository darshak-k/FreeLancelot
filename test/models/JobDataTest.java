package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Job data Test class to test JobData class
 * 
 * @author Darshak Kachchhi
 */
public class JobDataTest {

	@Test
	public void getNameTest() {
		JobData job = new JobData();
		job.setName("Java");

		assertEquals("Java", job.getName());
	}

}
