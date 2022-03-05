package com.mpp.serializer;

public class StorageSerializer extends Serializer {

    private final String fileName;

    public StorageSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    String getFileName() {
        return fileName;
    }
}
