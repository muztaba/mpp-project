package com.mpp.repository;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.BookCopy;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookRepositoryTest {

    @Test
    public void save() {
        BookRepository bookRepository = RepositoryFactory.bookRepository();

        Book book = new Book("123", "Book Title", "isbn");

        Author author = new Author();
        author.setId("890");
        author.setFirstName("firstName");

        BookCopy bookCopy = new BookCopy(book);

        book.setAuthors(List.of(author));
        book.setCopies(List.of(bookCopy));

        bookRepository.save(book);
    }

}