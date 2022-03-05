package com.mpp.model;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Identifiable {
    private List<CheckoutEntry> checkoutEntries;
    private List<LateReturn> lateReturns;

    public CheckoutRecord() {
        checkoutEntries = new ArrayList<CheckoutEntry>();
        lateReturns = new ArrayList<LateReturn>();
    }

    public void addCheckoutEntry(CheckoutEntry checkoutEntry) {
        checkoutEntries.add(checkoutEntry);
    }

    public void addLateReturn(LateReturn lateReturn) {
        lateReturns.add(lateReturn);
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }

    public void setCheckoutEntries(List<CheckoutEntry> checkoutEntries) {
        this.checkoutEntries = checkoutEntries;
    }

    public List<LateReturn> getLateReturns() {
        return lateReturns;
    }

    public void setLateReturns(List<LateReturn> lateReturns) {
        this.lateReturns = lateReturns;
    }

    @Override
    public String getID() {
        return null;
    }
}
