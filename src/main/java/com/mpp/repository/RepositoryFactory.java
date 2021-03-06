package com.mpp.repository;

final public class RepositoryFactory {

    private RepositoryFactory() {
    }

    private static LibraryMemberRepository libraryMemberRepository;
    private static BookRepository bookRepository;
    private static AuthorRepository authorRepository;
    private static CheckoutRecordRepository checkoutRecordRepository;

    public static LibraryMemberRepository libraryMemberRepository() {
        if (libraryMemberRepository == null) {
            libraryMemberRepository = new LibraryMemberRepository();
        }

        return libraryMemberRepository;
    }

    public static BookRepository bookRepository() {
        if (bookRepository == null) {
            bookRepository = new BookRepository();
        }

        return bookRepository;
    }

    public static AuthorRepository authorRepository() {
        if (authorRepository == null) {
            authorRepository = new AuthorRepository();
        }

        return authorRepository;
    }

    public static CheckoutRecordRepository checkoutRecordRepository() {
        if (checkoutRecordRepository == null) {
            checkoutRecordRepository = new CheckoutRecordRepository();
        }

        return checkoutRecordRepository;
    }

}
