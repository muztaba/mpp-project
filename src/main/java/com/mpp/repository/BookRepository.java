package com.mpp.repository;

import com.mpp.model.Book;
import com.mpp.model.BookCopy;
import com.mpp.serializer.ISerializer;
import com.mpp.serializer.Storage;
import com.mpp.utils.ApplicationContext;

public class BookRepository extends Repository<Book> {

    BookRepository() {
        super(ApplicationContext.storage.books);
    }

    public Book findByIsbn(String isbn) {
        return this.findAll()
                .stream()
                .filter(it -> it.getIsbn().equals(isbn))
                .findAny()
                .orElse(null);
    }

    public BookCopy findFirstAvailableBookCopy(Book book) {
        return book.getCopies()
                .stream()
                .filter(copy -> copy.getAvailable())
                .findFirst()
                .orElse(null);
    }
}
