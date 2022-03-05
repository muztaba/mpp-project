package com.mpp.repository;

import com.mpp.model.Book;
import com.mpp.serializer.ISerializer;
import com.mpp.serializer.Storage;

public class BookRepository extends Repository<Book> {

    BookRepository() {
        super(Storage.INSTANCE.books);
    }

}
