package com.mpp.serializer;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.LibraryMember;

import java.util.HashMap;
import java.util.Map;

public final class SerializerFactory {
    static Map<Class<? extends Object>, ISerializer> serializerMap = new HashMap<Class<? extends Object>, ISerializer>() {{
        put(Book.class, new BookSerializer());
        put(LibraryMember.class, new LibraryMemberSerializer());
        put(Author.class, new AuthorSerializer());
    }};

    private SerializerFactory() {
    }

    public static ISerializer getSerializer(Class<? extends Object> clazz) {
        return serializerMap.get(clazz);
    }
}
