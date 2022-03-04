package com.mpp.controller;

import com.mpp.exception.ValidationException;
import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.repository.RepositoryFactory;
import com.mpp.serializer.SerializerFactory;
import com.mpp.validation.ValidatorFactory;
import com.mpp.repository.BookRepository;
import com.mpp.utils.Validator;
import com.mpp.utils.WrongInput;

import java.util.List;
import java.util.UUID;

public class BookController implements DomainController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addNewBook(String title, String isbn, List<String> authorNames) throws ValidationException {
        // TODO: check if the user has access to this operation

        Book book = new Book(UUID.randomUUID().toString(), title, isbn);
        book.setAvailable(true);
        // get Author by author name and add to the book
        for (String authorName : authorNames) {
            // Get AuthorController from ControllerFactory
            Author author = ((AuthorController) ControllerFactory.getController(Author.class)).getAuthorByName(authorName);
            book.addAuthor(author);
        }
        // Validate input and handle exception
        ValidatorFactory.getValidator(Book.class).validate(book);
        // TODO: create a book copy for this copy
        // TODO: save the book using BookRepository and return book
        // RepositoryFactory.getLibraryMemberRepository().save(book);

        return bookRepository.save(book);
    }

    public Book searchBookByIsbn(String isbn) {
        return bookRepository.findById(isbn);
    }
}
