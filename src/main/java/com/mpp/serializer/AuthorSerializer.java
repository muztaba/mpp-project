package com.mpp.serializer;

public class AuthorSerializer extends Serializer {

    private final String fileName;

    public AuthorSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    String getFileName() {
        return fileName;
    }
}
