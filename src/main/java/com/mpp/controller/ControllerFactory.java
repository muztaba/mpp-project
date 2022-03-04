package com.mpp.controller;

public final class ControllerFactory {
    private static BookController bookController;
    private static AuthorController authorController;


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

}
