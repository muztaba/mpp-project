package com.mpp.repository;

import com.mpp.model.Author;
import com.mpp.serializer.ISerializer;
import com.mpp.serializer.Storage;

public class AuthorRepository extends Repository<Author> {

    public AuthorRepository(ISerializer serializer) {
        super(serializer, Storage.INSTANCE.authors);
    }

}
