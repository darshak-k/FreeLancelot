package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Freelancer Project class to store details of project
 * 
 * @author Darshak Kachchhi, Mansi Lakhani and Apeksha Gohil
 */
public class FreelancerProject {

	public String id;
	public String owner_id;
	public String title;
	public String status;
	public String preview_description;
	public String seo_url;
	public String type;
	public long submitdate;
	public List<JobData> jobs;
	public Date submit_date;
	public String date_string;

	public FreelancerProject() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPreview_description() {
		return preview_description;
	}

	public void setPreview_description(String preview_description) {
		this.preview_description = preview_description;
	}

	public String getSeo_url() {
		return seo_url;
	}

	public void setSeo_url(String seo_url) {
		this.seo_url = seo_url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(long submitdate) {
		this.submitdate = submitdate;
	}

	public List<JobData> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobData> jobs) {
		this.jobs = jobs;
	}

	public Date getSubmit_date() {
		setSubmit_date(new Date(getSubmitdate() * 1_000L));
		return submit_date;
	}

	public void setSubmit_date(Date submit_date) {
		this.submit_date = submit_date;
	}

	public String getDate_string() {
		SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
		date_string = df.format(getSubmit_date());
		return date_string;
	}

	public void setDate_string(String date_string) {
		this.date_string = date_string;
	}

}
