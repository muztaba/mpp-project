package com.mpp.controller;

import com.mpp.repository.RepositoryFactory;

public final class ControllerFactory {
    private static BookController bookController;
    private static AuthorController authorController;
    private static LibraryMemberController libraryMemberController;

    private ControllerFactory() {}

    public static BookController getBookController() {
        if (bookController == null) {
            bookController = new BookController(RepositoryFactory.bookRepository());
        }
        return bookController;
    }

    public static AuthorController getAuthorController() {
        if (authorController == null) {
            authorController = new AuthorController(RepositoryFactory.authorRepository());
        }
        return authorController;
    }

    public static LibraryMemberController getLibraryMemberController() {
        if (libraryMemberController == null) {
            libraryMemberController = new LibraryMemberController(RepositoryFactory.libraryMemberRepository());
        }
        return libraryMemberController;
    }

}
