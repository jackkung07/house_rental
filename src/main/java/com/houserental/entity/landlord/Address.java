package com.houserental.entity.landlord;

public class Address {

    private String address;

    private String city;

    private String state;

    private String zipcode;

    private double lat;

    private double lng;

    public Address() {
    }

    public Address(String address, String city, String state, String zipcode) {
        super();
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.setLocation();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public double getLatitude() {
        return lat;
    }

    public void setLatitude(double latitude) {
        this.lat = latitude;
    }

    public double getLongitude() {
        return lng;
    }

    public void setLongitude(double longitude) {
        this.lng = longitude;
    }

    public void setLocation() {
        if ((address.isEmpty() && city.isEmpty() && state.isEmpty() && zipcode.isEmpty()) == false) {
            LongLatService longLatService = LongLatService.getInstance();
            longLatService.setAddress(address + " " + ", " + city + " " + state + " " + zipcode);
            this.lat = longLatService.getLat();
            this.lng = longLatService.getLng();
        }
    }

}
