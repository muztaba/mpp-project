package com.mpp.model;

import java.io.Serializable;
import java.util.Random;

public class BookCopy implements Serializable, Identifiable {
    private String id;
    private Book book;
    private Integer copyNumber;
    private Boolean isAvailable;

    public BookCopy(Book book) {
        this.id = String.valueOf(new Random().nextDouble());
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return getId();
    }
}
