package com.mpp.model;

public class LibraryMember extends Person implements Identifiable {
    private CheckoutRecord checkoutRecord;

    public LibraryMember(
            String id,
            String firstName,
            String lastName,
            Integer phone,
            String street,
            String city,
            String state,
            Integer zip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = new Address(street, city, state, zip);
    }

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    @Override
    public String getID() {
        return id;
    }

    public void setID(String id){ this.id = id;}


    @Override
    public String toString() {
        return "LibraryMember{" +
                "\n| uuid : " + this.getID() +
                "| checkoutRecord=" + checkoutRecord +
                "| Person=" + super.toString() +
                '}';
    }
}
