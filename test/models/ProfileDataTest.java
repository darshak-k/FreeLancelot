package models;

/**
 * ProfilData test classes to test ProfileData class
 * 
 * @author Apekshaba Gohil
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;



public class ProfileDataTest {
    ProfileData data = new ProfileData();

    @Test
    public void idTest() {
        data.setId("24304119");
        assertEquals("24304119", data.getId());
    }

    @Test
    public void usernameTest() {
        data.setUsername("korjon");
        assertEquals("korjon", data.getUsername());

    }

    @Test
    public void displaynameTest() {
        data.setDisplayname("korjon");
        assertEquals("korjon", data.getDisplayname());

    }

    @Test
    public void roleTest() {
        data.setRole("developer");
        assertEquals("developer", data.getRole());

    }

    @Test
    public void registrationdateTest() {
        data.setRegistrationdate("Java");
        assertEquals("Java", data.getRegistrationdate());

    }

    @Test
    public void chosenroleTest() {
        data.setChosenrole("developer");
        assertEquals("developer", data.getChosenrole());

    }

    @Test
    public void limitedaccountTest() {
        data.setLimitedaccount("Java");
        assertEquals("Java", data.getLimitedaccount());

    }

    @Test
    public void locationTest() {
        Country c = new Country();
        c.setName("India");
        LocationData l = new LocationData();
        l.setCountry(c);
        data.setLocation(l);
        assertEquals("India", data.getLocation().getCountry().getName());

    }

    @Test
    public void statusTest() {
        StatusData s = new StatusData();
        s.setEmail_varified("true");
        data.setStatus(s);
        assertEquals("true", data.getStatus().getEmail_varified());

    }

    @Test
    public void primary_currencyTest() {
        Primary_currencyData p = new Primary_currencyData();
        p.setName("EUR");
        data.setPrimary_currency(p);
        assertEquals("EUR", data.getPrimary_currency().getName());

    }





}
