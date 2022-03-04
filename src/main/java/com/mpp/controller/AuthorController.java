package com.mpp.controller;

import com.mpp.deserializer.DeserializerFactory;
import com.mpp.deserializer.IDeserializer;
import com.mpp.model.Author;

public class AuthorController {
    public Author getAuthorByName(String authorName) {
        // TODO: get author by name from AuthorDeserializer
        IDeserializer authorDeserializer = DeserializerFactory.getAuthorDeserializer();
        Author author = (Author) authorDeserializer.deserialize(authorName);
        return author;

    }
}
