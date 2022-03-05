package com.mpp.controller;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.CheckoutRecord;
import com.mpp.model.LibraryMember;
import com.mpp.repository.RepositoryFactory;

import java.util.Map;

public final class ControllerFactory {
    private static BookController bookController;
    private static AuthorController authorController;
    private static LibraryMemberController libraryMemberController;
    private static AuthenticationController authenticationController;

    private static Map<Class<? extends Object>, DomainController> controllerMap = Map.of(
            Book.class, new BookController(RepositoryFactory.bookRepository()),
            LibraryMember.class, new LibraryMemberController(RepositoryFactory.libraryMemberRepository()),
            Author.class, new AuthorController(RepositoryFactory.authorRepository()),
            AuthenticationController.class, new AuthenticationController(),
            CheckoutRecord.class, new CheckoutRecordController(RepositoryFactory.checkoutRecordRepository())
    );

    private ControllerFactory() {

    }

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

    public static AuthenticationController getAuthenticationController() {
        if (authenticationController == null) {
            authenticationController = new AuthenticationController();
        }

        return authenticationController;
    }

    public static DomainController getController(Class<? extends Object> clazz) {
        return controllerMap.get(clazz);
    }


}
