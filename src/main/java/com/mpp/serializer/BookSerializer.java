package com.mpp.serializer;

public class BookSerializer extends Serializer {

    private final String fileName;

    public BookSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    String getFileName() {
        return fileName;
    }
}
