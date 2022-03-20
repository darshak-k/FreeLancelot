package models;


/**
 * @author Apekshaba Gohil
 * @created 18/03/2022
 */

public class ProfileData {
    public String id;
    public String username;
    public String displayname;
    public String role;
    public String registrationdate;
    public String chosenrole;
    public String limitedaccount;
    public LocationData location;
    public StatusData status;
    public Primary_currencyData primary_currency;

    public ProfileData(){

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDisplayname() {
        return displayname;
    }
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getRegistrationdate() {
        return registrationdate;
    }
    public void setRegistrationdate(String registrationdate) {
        this.registrationdate = registrationdate;
    }
    public String getChosenrole() {
        return chosenrole;
    }
    public void setChosenrole(String chosenrole) {
        this.chosenrole = chosenrole;
    }
    public String getLimitedaccount() {
        return limitedaccount;
    }
    public void setLimitedaccount(String limitedaccount) {
        this.limitedaccount = limitedaccount;
    }
    public LocationData getLocation() {
        return location;
    }
    public void setLocation(LocationData location) {
        this.location = location;
    }
    public StatusData getStatus() {
        return status;
    }
    public void setStatus(StatusData status) {
        this.status = status;
    }
    public Primary_currencyData getPrimary_currency() {
        return primary_currency;
    }
    public void setPrimary_currency(Primary_currencyData primary_currency) {
        this.primary_currency = primary_currency;
    }
}
