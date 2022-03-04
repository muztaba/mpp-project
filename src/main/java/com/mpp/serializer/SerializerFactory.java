package com.mpp.serializer;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.LibraryMember;

import java.util.HashMap;
import java.util.Map;

public final class SerializerFactory {
    private static BookSerializer bookSerializer;

    private SerializerFactory() {}

    public static BookSerializer bookSerializer(String fileName) {
        if (bookSerializer == null) {
            bookSerializer = new BookSerializer(fileName);
        }
        return bookSerializer;
    }

    public static LibraryMemberSerializer libraryMemberSerializer(String fileName) {
        return new LibraryMemberSerializer(fileName);
    }

    public static ISerializer authorSerializer(String fileName) {
        return new AuthorSerializer(fileName);
    }

}
