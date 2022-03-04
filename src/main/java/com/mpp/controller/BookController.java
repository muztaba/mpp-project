package com.mpp.controller;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.repository.BookRepository;
import com.mpp.utils.Validator;
import com.mpp.utils.WrongInput;

import java.util.List;

public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addNewBook(String title, String isbn, List<String> authorNames) throws WrongInput {
        // TODO: check if the user has access to this operation

        Validator.isValidString(title);
        Validator.isValidISBN(isbn);
        for (String authorName : authorNames) {
            Validator.isValidString(authorName);
        }

        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setAvailable(true);
        // get Author by author name and add to the book
        for (String authorName : authorNames) {
            // Get AuthorController from ControllerFactory
            Author author = ControllerFactory.getAuthorController().getAuthorByName(authorName);
            book.addAuthor(author);
        }

        return bookRepository.save(book);
    }

    public Book searchBookByIsbn(String isbn) {
        return bookRepository.findById(isbn);
    }
}
