package com.mpp.controller;

import com.mpp.model.LibraryMember;

public final class ControllerFactory {
    private static BookController bookController;
    private static AuthorController authorController;
    private static LibraryMemberController libraryMemberController;

    public static BookController getBookController() {
        if (bookController == null) {
            bookController = new BookController();
        }
        return bookController;
    }
    public static AuthorController getAuthorController() {
        if (authorController == null) {
            authorController = new AuthorController();
        }
        return authorController;
    }
    public static LibraryMemberController getLibraryMemberController() {
        if (libraryMemberController == null) {
            libraryMemberController = new LibraryMemberController();
        }
        return libraryMemberController;
    }

}
