package com.mpp.model;

import java.util.Date;

public class CheckoutEntry {
    private BookCopy bookCopy;
    private Date checkoutDate;
    private Date dueDate;
    private User checkoutBy;
    private LibraryMember borrowedBy;
    private float fine;

    public CheckoutEntry(BookCopy bookCopy, Date checkoutDate, Date dueDate, User checkoutBy, LibraryMember borrowedBy) {
        this.bookCopy = bookCopy;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.checkoutBy = checkoutBy;
        this.borrowedBy = borrowedBy;
    }

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

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }
}
