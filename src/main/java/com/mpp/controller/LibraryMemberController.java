package com.mpp.controller;

import com.mpp.model.LibraryMember;

import java.util.UUID;

public class LibraryMemberController {
    public LibraryMember createLibraryMember(
            String firstName,
            String lastName,
            Integer phoneNumber,
            String street,
            String city,
            String state,
            Integer zip) {

        LibraryMember libraryMember = new LibraryMember(UUID.randomUUID().toString(),
                firstName,
                lastName,
                phoneNumber,
                street,
                city,
                state,
                zip);

        // TODO: call dao to save
        return libraryMember;
    }
}
