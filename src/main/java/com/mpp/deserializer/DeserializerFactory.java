package com.mpp.deserializer;

import com.mpp.controller.AuthorController;
import com.mpp.controller.BookController;
import com.mpp.controller.DomainController;
import com.mpp.controller.LibraryMemberController;
import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.LibraryMember;

import java.util.HashMap;
import java.util.Map;

public final class DeserializerFactory {
    static Map<Class<? extends Object>, IDeserializer> deserializerMap = new HashMap<Class<? extends Object>, IDeserializer>() {{
        put(Book.class, new BookDeserializer());
        put(LibraryMember.class, new LibraryMemberDeserializer());
        put(Author.class, new AuthorDeserializer());
    }};

    private DeserializerFactory() {
    }

    public static IDeserializer getDeserializer(Class<? extends Object> clazz) {
        return deserializerMap.get(clazz);
    }
}
