package com.mpp.controller;

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
    }};

    private ControllerFactory() {
    }

    public static DomainController getController(Class<? extends Object> clazz) {
        return controllerMap.get(clazz);
    }

}
