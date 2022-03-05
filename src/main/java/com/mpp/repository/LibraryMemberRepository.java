package com.mpp.repository;

import com.mpp.model.LibraryMember;
import com.mpp.utils.ApplicationContext;

public class LibraryMemberRepository extends Repository<LibraryMember> {

    LibraryMemberRepository() {
        super(ApplicationContext.storage.libraryMembers);
    }

}
