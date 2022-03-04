package com.mpp.repository;

import com.mpp.model.LibraryMember;
import com.mpp.serializer.ISerializer;

public class LibraryMemberRepository extends Repository<LibraryMember>{

    public LibraryMemberRepository(ISerializer serializer) {
        super(serializer);
    }

}
