package com.mpp.model;

import java.io.Serializable;

public class Author extends Person implements Identifiable, Serializable {
    private String bio;

    public Author(
            String id,
            String firstName,
            String lastName,
            Integer phone,
            String street,
            String city,
            String state,
            Integer zip,
            String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = new Address(street, city, state, zip);
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "| firstName='" + firstName + '\'' +
                "| lastName='" + lastName + '\'' +
                "| address=" + address +
                "| phone=" + phone +
                '}';
    }
}
