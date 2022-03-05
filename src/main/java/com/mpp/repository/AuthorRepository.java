package com.mpp.repository;

import com.mpp.model.Author;
import com.mpp.serializer.Storage;
import com.mpp.utils.ApplicationContext;

public class AuthorRepository extends Repository<Author> {

    public AuthorRepository() {
        super(ApplicationContext.storage.authors);
    }
    public Author findByFirstName(String firstName) {
        return this.findAll()
                .stream()
                .filter(it -> it.getFirstName().equals(firstName))
                .findAny()
                .orElse(null);
    }
}
