package api.data;

import api.json.Timezone;

public class PrimaryAddress {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String timeZone;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public PrimaryAddress withStreet(String street) {
        setStreet(street);
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PrimaryAddress withCity(String city) {
        setCity(city);
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PrimaryAddress withState(String state) {
        setState(state);
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public PrimaryAddress withZipCode(String zipCode) {
        setZipCode(zipCode);
        return this;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Timezone timeZone) {
        this.timeZone =
                timeZone.getDescription() +
                " " +
                timeZone.getOffset();
    }

    public PrimaryAddress withTimeZone(Timezone timeZone) {
        setTimeZone(timeZone);
        return this;
    }
}
