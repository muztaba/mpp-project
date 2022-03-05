package com.mpp.repository;

import com.mpp.model.Author;
import com.mpp.serializer.Storage;

public class AuthorRepository extends Repository<Author> {

    public AuthorRepository() {
        super(Storage.INSTANCE.authors);
    }

}
