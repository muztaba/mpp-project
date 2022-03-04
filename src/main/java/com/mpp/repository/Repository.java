package com.mpp.repository;

import com.mpp.model.Identifiable;
import com.mpp.serializer.ISerializer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

abstract public class Repository<T extends Identifiable> {

    private final ISerializer serializer;
    private final Map<String, T> map;

    public Repository(ISerializer serializer, Map<String, T> map) {
        this.serializer = serializer;
        this.map = (map == null) ? new HashMap<>() : map;
    }

    public T save(T t) {
        map.put(t.getID(), t);
        serializer.serialize(map);
        return t;
    }

    public T findById(String id) {
        for (Map.Entry<String, T> it : map.entrySet()) {
            if (it.getKey().equals(id)) {
                return it.getValue();
            }
        }

        return null;
    }

    public Collection<T> findAll() {
        return map.values();
    }
}
