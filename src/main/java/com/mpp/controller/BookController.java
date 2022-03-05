package com.mpp.controller;

import com.mpp.exception.ValidationException;
import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.BookCopy;
import com.mpp.repository.BookRepository;
import com.mpp.validation.ValidatorFactory;

import java.util.List;
import java.util.UUID;

public class BookController implements DomainController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addNewBook(String title, String isbn, Integer borrowDurationInDays, List<String> authorNames) throws ValidationException {
        Book book = new Book(UUID.randomUUID().toString(), title, isbn, borrowDurationInDays);
        book.setAvailable(true);
        // get Author by author name and add to the book
        for (String authorName : authorNames) {
            // Get AuthorController from ControllerFactory
            Author author = ((AuthorController) ControllerFactory.getController(Author.class)).getAuthorByName(authorName);
            book.addAuthor(author);
        }
        // Validate input and handle exception
        ValidatorFactory.getValidator(Book.class).validate(book);
        BookCopy bookCopy = new BookCopy(book);
        book.addBookCopy(bookCopy);
        return bookRepository.save(book);
    }

    public Book addNewBookCopy(String isbn) {
        Book book = searchBookByIsbn(isbn);
        BookCopy bookCopy = new BookCopy(searchBookByIsbn(isbn));
        book.addBookCopy(bookCopy);
        return bookRepository.save(book);
    }

    public Book searchBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }


}
