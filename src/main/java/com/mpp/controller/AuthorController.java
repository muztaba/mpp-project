package com.mpp.controller;

import com.mpp.exception.ValidationException;
import com.mpp.model.Author;
import com.mpp.model.LibraryMember;
import com.mpp.repository.AuthorRepository;
import com.mpp.validation.ValidatorFactory;

import java.util.Collection;
import java.util.UUID;

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

    public Author createAuthor(String fname,
                               String lname,
                               int phoneNumber,
                               String street,
                               String city,
                               String state,
                               int zip, String bio) throws ValidationException {

        Author author = new Author(
                UUID.randomUUID().toString(),
                fname,
                lname,
                phoneNumber,
                street,
                city,
                state,
                zip, bio);
        ValidatorFactory.getValidator(Author.class).validate(author);
        authorRepository.save(author);
        return author;
    }
}
