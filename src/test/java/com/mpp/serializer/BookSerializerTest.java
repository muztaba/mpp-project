package com.mpp.serializer;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.BookCopy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class BookSerializerTest {

    static final String fileName = "src/test/resources/bookTest.bin";

    @AfterEach
    public void afterEach() {
        new File(fileName).delete();
    }

    @Test
    public void serialize() {
        // setup
        Book book = createBook();
        var map = Map.of(book.getID(), book);
        BookSerializer bookSerializer = SerializerFactory.bookSerializer(fileName);

        // when
        bookSerializer.serialize(map);

        // then
        var actualMap = (Map<String, Book>) bookSerializer.deserialize();

        Assertions.assertThat(actualMap).isNotNull();
        Assertions.assertThat(map.get(book.getID())).isNotNull();

        Book actual = map.get(book.getID());
        Assertions.assertThat(actual.getAuthors().get(0).getFirstName())
                .isEqualTo(book.getAuthors().get(0).getFirstName());
    }

    @Test
    public void whenFileNotFound() {
        BookSerializer bookSerializer = SerializerFactory.bookSerializer(fileName);
        Object deserialize = bookSerializer.deserialize();
        Assertions.assertThat(deserialize).isNull();
    }

    Book createBook() {
        Book book = new Book("123", "Book Title", "isbn");

        Author author = new Author();
        author.setId("890");
        author.setFirstName("firstName");

        BookCopy bookCopy = new BookCopy(book);

        book.setAuthors(List.of(author));
        book.setCopies(List.of(bookCopy));
        return book;
    }

}