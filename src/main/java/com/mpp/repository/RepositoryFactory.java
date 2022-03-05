package com.mpp.repository;

import com.mpp.serializer.SerializerFactory;

final public class RepositoryFactory {

    private static final String storage = "storage/";

    private RepositoryFactory() {
    }

    private static LibraryMemberRepository libraryMemberRepository;
    private static BookRepository bookRepository;
    private static AuthorRepository authorRepository;

    public static LibraryMemberRepository libraryMemberRepository() {
        if (libraryMemberRepository == null) {
            libraryMemberRepository = new LibraryMemberRepository(SerializerFactory.libraryMemberSerializer(storage + "libraryMember.bin"));
        }

        return libraryMemberRepository;
    }

    public static BookRepository bookRepository() {
        if (bookRepository == null) {
            bookRepository = new BookRepository(SerializerFactory.bookSerializer(storage + "book.bin"));
        }

        return bookRepository;
    }

    public static AuthorRepository authorRepository() {
        if (authorRepository == null) {
            authorRepository = new AuthorRepository(SerializerFactory.authorSerializer(storage + "author.bin"));
        }

        return authorRepository;
    }

}
