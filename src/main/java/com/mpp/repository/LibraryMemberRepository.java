package com.mpp.repository;

import com.mpp.model.LibraryMember;
import com.mpp.serializer.ISerializer;
import com.mpp.serializer.Storage;

public class LibraryMemberRepository extends Repository<LibraryMember> {

    LibraryMemberRepository(ISerializer serializer) {
        super(serializer, Storage.INSTANCE.libraryMembers);
    }

}
