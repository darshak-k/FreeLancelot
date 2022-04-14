package models;

/**
 * Profile Response class to store the API Response of profile
 * @author Apekshaba Gohil
 */

public class ProfileResponce {
    public String status;
    public String request_id;
    public ProfileData result;

    public ProfileResponce() {
    }

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

    public ProfileData getResult() {
        return result;
    }

    public void setResult(ProfileData result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "APIResponceWrap [status=" + status + ", request_id=" + request_id + ", result=" + result + "]";
    }

}
