package com.mpp.repository;

import com.mpp.model.Author;
import com.mpp.serializer.ISerializer;

import java.util.List;

public class AuthorRepository extends Repository<Author> {
    public AuthorRepository(ISerializer bookSerializer) {
        super(bookSerializer);
    }

    public Author findByName(String authorName) {
        List<Author> authors = (List<Author>) super.findAll();
        for (Author author : authors) {
            if (authorName.equals(author.getFirstName())) {
                return author;
            }
        }
        return null;
    }
}
