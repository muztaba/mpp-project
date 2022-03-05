package com.mpp.model;

public class Author extends Person implements Identifiable {
    private String bio;

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
                "\nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \naddress=" + address +
                ", \nphone=" + phone +
                '}';
    }
}
