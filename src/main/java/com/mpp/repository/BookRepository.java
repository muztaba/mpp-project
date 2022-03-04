package com.mpp.repository;

import com.mpp.model.Book;
import com.mpp.serializer.ISerializer;

import java.util.Map;

public class BookRepository extends Repository<Book> {

    BookRepository(ISerializer bookSerializer) {
        super(bookSerializer,  (Map<String, Book>) bookSerializer.deserialize());
    }

}
