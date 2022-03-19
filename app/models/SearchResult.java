package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Search result class to store searching query records
 * 
 * @author Darshak Kachchhi
 * @created 15/03/22
 */
public class SearchResult {
	protected String query;
	protected List<FreelancerProject> projects;

	public SearchResult() {
		query = "";
		projects = new ArrayList<FreelancerProject>();
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void setProjects(List<FreelancerProject> projects) {
		this.projects = projects;
	}

	public List<FreelancerProject> getProjects() {
		return projects;
	}
}