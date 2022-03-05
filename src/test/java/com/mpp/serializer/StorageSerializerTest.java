package com.mpp.serializer;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.BookCopy;
import com.mpp.model.LibraryMember;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;

class StorageSerializerTest {

    static final String fileName = "storage/db_test.bin";

    @Test
    public void serialize() {
        // setup
        StorageSerializer serializer = new StorageSerializer(fileName);

        Map<String, Book> map = Storage.INSTANCE.books;

        var b = createBook();
        map.put(b.getID(), b);

        Map<String, LibraryMember> map1 = Storage.INSTANCE.libraryMembers;
        LibraryMember libraryMember = new LibraryMember("111", "first", "last",
                1234566789, "street", "city", "state", 1234);

        map1.put(libraryMember.getID(), libraryMember);

        serializer.serialize(Storage.INSTANCE);
        var actualStorage = (Storage) serializer.deserialize();

        Assertions.assertThat(actualStorage.books.get(b.getID())).isNotNull();
        Assertions.assertThat(actualStorage.libraryMembers.get(libraryMember.getID())).isNotNull();

    }

    @Test
    public void deserialize() {
        StorageSerializer serializer = new StorageSerializer(fileName);
        serializer.deserialize();


        Assertions.assertThat(Storage.INSTANCE.books).isNotNull();
        Assertions.assertThat(Storage.INSTANCE.libraryMembers).isNotNull();

        new File(fileName).delete();
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