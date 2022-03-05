package com.mpp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable, Identifiable {
    public static int numberOfCopies;
    private String id;
    private String isbn;
    private String title;
    private Integer borrowDurationInDays;
    private List<Author> authors;
    private List<BookCopy> copies;
    private Boolean isAvailable;

    public Book(String id, String title, String isbn, Integer borrowDurationInDays) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.borrowDurationInDays = borrowDurationInDays;
        authors = new ArrayList<>();
        copies = new ArrayList<>();
    }

    public Integer getBorrowDurationInDays() {
        return borrowDurationInDays;
    }

    public void setBorrowDurationInDays(Integer borrowDurationInDays) {
        this.borrowDurationInDays = borrowDurationInDays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addBookCopy(BookCopy bookCopy) {
        copies.add(bookCopy);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String getID() {
        return id;
    }


    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors.toString() +
                ", copies=" + copies +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
