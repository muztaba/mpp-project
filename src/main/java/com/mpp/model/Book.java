package com.mpp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable, Identifiable {
    private String isbn;
    private String title;
    private List<Author> authors;
    private List<BookCopy> copies;
    private Boolean isAvailable;

    public Book() {
        authors = new ArrayList<>();
        copies = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addCopy(BookCopy bookCopy) {
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
        return isbn;
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
