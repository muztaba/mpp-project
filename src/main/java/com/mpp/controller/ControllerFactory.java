package com.mpp.controller;

import com.mpp.repository.RepositoryFactory;
import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.LibraryMember;

import java.util.HashMap;
import java.util.Map;

public final class ControllerFactory {
    static Map<Class<? extends Object>, DomainController> controllerMap = new HashMap<Class<? extends Object>, DomainController>() {{
        put(Book.class, new BookController());
        put(LibraryMember.class, new LibraryMemberController());
        put(Author.class, new AuthorController());
        put(AuthenticationController.class, new AuthenticationController());
    }};

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

    public static DomainController getController(Class<? extends Object> clazz) {
        return controllerMap.get(clazz);
    }

}
