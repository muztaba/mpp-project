package com.mpp.model;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Identifiable {
    private List<CheckoutEntry> checkoutEntries;

    public CheckoutRecord() {
        checkoutEntries = new ArrayList<CheckoutEntry>();
    }

    public void addCheckoutEntry(CheckoutEntry checkoutEntry) {
        checkoutEntries.add(checkoutEntry);
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }

    public void setCheckoutEntries(List<CheckoutEntry> checkoutEntries) {
        this.checkoutEntries = checkoutEntries;
    }

    @Override
    public String getID() {
        return null;
    }
}
