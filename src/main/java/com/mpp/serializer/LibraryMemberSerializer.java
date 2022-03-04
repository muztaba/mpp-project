package com.mpp.serializer;

public class LibraryMemberSerializer extends Serializer {

    private final String fileName;

    public LibraryMemberSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    String getFileName() {
        return fileName;
    }
}
