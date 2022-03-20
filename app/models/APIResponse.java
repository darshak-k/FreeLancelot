package models;

/**
 * Response of API Call
 * 
 * @author Darshak Kachchhi, Mansi Lakhani and Apekshaba Gohil
 * @created 14/03/2022
 */
public class APIResponse {
	public String status;
	public String request_id;
	public APIResultData result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public APIResultData getResult() {
		return result;
	}

	public void setResult(APIResultData result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "APIResponceWrap [status=" + status + ", request_id=" + request_id + ", result=" + result + "]";
	}

}
