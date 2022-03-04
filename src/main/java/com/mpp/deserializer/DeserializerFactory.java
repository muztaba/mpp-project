package com.mpp.deserializer;

public final class DeserializerFactory {
    private static AuthorDeserializer authorDeserializer;

    public static AuthorDeserializer getAuthorDeserializer() {
        if (authorDeserializer == null) {
            authorDeserializer = new AuthorDeserializer();
        }
        return authorDeserializer;
    }
}
