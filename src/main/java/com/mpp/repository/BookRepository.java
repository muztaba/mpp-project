package com.mpp.repository;

import com.mpp.model.Book;
import com.mpp.serializer.BookSerializer;
import com.mpp.serializer.ISerializer;

public class BookRepository extends Repository<Book> {
    public BookRepository(ISerializer bookSerializer) {
        super(bookSerializer);
    }
}
