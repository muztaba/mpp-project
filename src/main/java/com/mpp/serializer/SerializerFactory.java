package com.mpp.serializer;

public final class SerializerFactory {
    private static BookSerializer bookSerializer;

    public static BookSerializer getBookSerializer() {
        if (bookSerializer == null) {
            bookSerializer = new BookSerializer();
        }
        return bookSerializer;
    }
}
