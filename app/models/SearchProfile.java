package models;

/**
 * @author  Apeksha Gohil
 */
public class SearchProfile {
    protected String query;
    protected ProfileData profiledata;

    public SearchProfile(){
        
    }

    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public ProfileData getProfiledata() {
        return profiledata;
    }
    public void setProfiledata(ProfileData profiledata) {
        this.profiledata = profiledata;
    }
    
}
