package com.mpp.repository;

import com.mpp.model.LibraryMember;
import com.mpp.serializer.ISerializer;

import java.util.Map;

public class LibraryMemberRepository extends Repository<LibraryMember> {

    LibraryMemberRepository(ISerializer serializer) {
        super(serializer, (Map<String, LibraryMember>) serializer.deserialize());
    }

}
