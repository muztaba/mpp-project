package com.mpp.model;

import java.io.Serializable;

public class BookCopy implements Serializable {
    private Book book;
    private Integer copyNumber;
    private Boolean isAvailable;

    public BookCopy(Book book) {
        this.book = book;
        Book.numberOfCopies += 1;
        this.copyNumber = Book.numberOfCopies;
        this.isAvailable = true;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(Integer copyNumber) {
        this.copyNumber = copyNumber;
    }
}
