package models;

import java.util.List;

/**
 * Result data of API call and total number of count list of freelancer project
 * 
 * @author Darshak Kachchhi, Mansi Lakhani and Apekshaba Gohil
 * @created 14/03/2022
 */
public class APIResultData {

	public List<FreelancerProject> projects;
	public int total_count;

	public APIResultData() {
	}

	public APIResultData(List<FreelancerProject> projects, int count) {
		this.projects = projects;
		this.total_count = count;
	}

	public List<FreelancerProject> getProjects() {
		return projects;
	}

	public void setProjects(List<FreelancerProject> projects) {
		this.projects = projects;
	}

	public int getCount() {
		return total_count;
	}

	public void setCount(int total_count) {
		this.total_count = total_count;
	}
}
