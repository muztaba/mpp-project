package com.mpp.model;

import java.util.List;

public class CheckoutRecord {
    private List<CheckoutEntry> checkoutEntries;
    private List<LateReturn> lateReturns;

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
}
