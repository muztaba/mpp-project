package com.mpp.model;

import java.io.Serializable;

public class BookCopy implements Serializable {
    private Book book;
    private Integer copyNumber;

    public BookCopy(Book book) {
        this.book = book;
        Book.numberOfCopies += 1;
        this.copyNumber = Book.numberOfCopies;
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
