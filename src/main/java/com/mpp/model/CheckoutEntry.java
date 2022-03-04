package com.mpp.model;

import java.time.LocalDate;
import java.util.Date;

public class CheckoutEntry {
    private BookCopy bookCopy;
    private Date checkoutDate;
    private Date dueDate;
    private User checkoutBy;
    private LibraryMember borrowedBy;

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getCheckoutBy() {
        return checkoutBy;
    }

    public void setCheckoutBy(User checkoutBy) {
        this.checkoutBy = checkoutBy;
    }

    public LibraryMember getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(LibraryMember borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
