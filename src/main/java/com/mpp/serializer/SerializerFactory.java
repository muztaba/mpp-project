package com.mpp.serializer;

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
