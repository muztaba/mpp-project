package com.mpp.model;

import java.io.Serializable;

public class Person implements Serializable, Identifiable {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected Address address;
    protected Integer phone;

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Person{" +
                "\nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \naddress=" + address +
                ", \nphone=" + phone +
                '}';
    }

    @Override
    public String getID() {
        return id;
    }
}
