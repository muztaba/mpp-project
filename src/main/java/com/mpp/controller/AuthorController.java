package com.mpp.controller;

import com.mpp.model.Author;
import com.mpp.repository.AuthorRepository;

import java.util.Collection;

public class AuthorController implements DomainController {

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private final AuthorRepository authorRepository;

    public Author getAuthorByName(String authorName) {
        return authorRepository.findByFirstName(authorName);
    }

    public Collection<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
