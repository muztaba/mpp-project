package com.mpp.controller;

import com.mpp.deserializer.DeserializerFactory;
import com.mpp.deserializer.IDeserializer;
import com.mpp.model.Author;
import com.mpp.repository.AuthorRepository;
import com.mpp.repository.RepositoryFactory;

public class AuthorController implements DomainController {
    public Author getAuthorByName(String authorName) {
        Author author = ((AuthorRepository) RepositoryFactory.getRepository(Author.class)).findByName(authorName);
        return author;

    }
}
