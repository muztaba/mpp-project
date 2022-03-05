package com.mpp.model;

import java.io.Serializable;

public class Address implements Serializable {
    private String street;
    private String city;
    private String state;
    private Integer zip;

    public Address(String street, String city, String state, Integer zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "| street='" + street + '\'' +
                "| city='" + city + '\'' +
                "| state='" + state + '\'' +
                "| zip=" + zip +
                '}';
    }

}
