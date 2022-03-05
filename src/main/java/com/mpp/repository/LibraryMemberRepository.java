package com.mpp.repository;

import com.mpp.model.LibraryMember;
import com.mpp.serializer.Storage;

public class LibraryMemberRepository extends Repository<LibraryMember> {

    LibraryMemberRepository() {
        super(Storage.INSTANCE.libraryMembers);
    }

}
