package com.mpp.serializer;

public interface ISerializer {
    void serialize(Object obj);

    Object deserialize();
}
