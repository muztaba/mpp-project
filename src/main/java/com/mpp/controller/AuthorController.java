package com.mpp.controller;

import com.mpp.model.Author;
import com.mpp.repository.AuthorRepository;

public class AuthorController {

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private final AuthorRepository authorRepository;

    public Author getAuthorByName(String authorName) {
        return authorRepository.findAll()
                .stream()
                .filter(it -> it.getFirstName().equals(authorName))
                .findAny()
                .orElse(null);
    }
}
