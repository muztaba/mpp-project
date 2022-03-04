package com.mpp.serializer;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.BookCopy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(actualMap).isNotNull();
        assertThat(map.get(book.getID())).isNotNull();

        Book actual = map.get(book.getID());
        assertThat(actual.getAuthors().get(0).getFirstName())
                .isEqualTo(book.getAuthors().get(0).getFirstName());
    }

    @Test
    public void whenFileNotFound() {
        BookSerializer bookSerializer = SerializerFactory.bookSerializer(fileName);
        Object deserialize = bookSerializer.deserialize();
        assertThat(deserialize).isNull();
    }

    @Test
    public void appendTest() {
        // setup
        var serializer = new BookSerializer("book_test.bin");

        var b1 = createBook();
        var map = new HashMap<>();
        map.put(b1.getID(), b1);
        serializer.serialize(map);

        var b2 = createBook();
        map.put(b2.getID(), b2);
        serializer.serialize(map);

        var actual = (Map<String, Book>) serializer.deserialize();

        assertThat(actual.get(b2.getID())).isNotNull();
        assertThat(actual.get(b1.getID())).isNotNull();

        var actualB2 = actual.get(b2.getID());

        assertThat(actualB2.getID()).isEqualTo(b2.getID());
        assertThat(actualB2.getAuthors().get(0).getFirstName())
                .isEqualTo(b2.getAuthors().get(0).getFirstName());
    }

    Book createBook() {
        String rand = String.valueOf(new Random().nextInt());
        Book book = new Book("123" + rand, "Book Title", "isbn");

        Author author = new Author();
        author.setId("890");
        author.setFirstName("firstName" + rand);

        BookCopy bookCopy = new BookCopy(book);

        book.setAuthors(List.of(author));
        book.setCopies(List.of(bookCopy));
        return book;
    }

}