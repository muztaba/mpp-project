package com.mpp.repository;

import com.mpp.model.LibraryMember;
import com.mpp.serializer.SerializerFactory;
import com.mpp.serializer.BookSerializer;
import com.mpp.serializer.LibraryMemberSerializer;
import com.mpp.validation.BookValidator;
import com.mpp.validation.IValidator;
import com.mpp.validation.LibraryMemberValidator;

import java.util.HashMap;
import java.util.Map;

final public class RepositoryFactory {

    private RepositoryFactory() {
    }

    private static LibraryMemberRepository libraryMemberRepository;
    private static BookRepository bookRepository;
    private static AuthorRepository authorRepository;

    static Map<Class<? extends Object>, Repository> repositoryMap = new HashMap<Class<? extends Object>, Repository>() {{
        put(Book.class, new BookRepository(new BookSerializer()));
        put(LibraryMember.class, new LibraryMemberRepository(new LibraryMemberSerializer()));
    }};

    public static Repository getRepository(Class<? extends Object> clazz) {
        return repositoryMap.get(clazz);
    }

    public static LibraryMemberRepository libraryMemberRepository() {
        if (libraryMemberRepository == null) {
            libraryMemberRepository = new LibraryMemberRepository(SerializerFactory.libraryMemberSerializer("libraryMember.bin"));
        }

        return libraryMemberRepository;
    }

    public static BookRepository bookRepository() {
        if (bookRepository == null) {
            bookRepository = new BookRepository(SerializerFactory.bookSerializer("book.bin"));
        }

        return bookRepository;
    }

    public static AuthorRepository authorRepository() {
        if (authorRepository == null) {
            authorRepository = new AuthorRepository(SerializerFactory.authorSerializer("author.bin"));
        }

        return authorRepository;
    }

}
