package com.mpp.controller;

import com.mpp.model.Author;
import com.mpp.repository.AuthorRepository;

public class AuthorController implements DomainController {

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private final AuthorRepository authorRepository;

    public Author getAuthorByName(String authorName) {
        return authorRepository.findByFirstName(authorName);
    }
}
