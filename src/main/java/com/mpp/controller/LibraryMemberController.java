package com.mpp.controller;

import com.mpp.exception.ValidationException;
import com.mpp.model.Address;
import com.mpp.model.LibraryMember;
import com.mpp.repository.RepositoryFactory;
import com.mpp.validation.ValidatorFactory;

import java.util.UUID;

public class LibraryMemberController implements DomainController {
    public LibraryMember createLibraryMember(
            String firstName,
            String lastName,
            Integer phone,
            String street,
            String city,
            String state,
            Integer zip) throws ValidationException {

        LibraryMember libraryMember = new LibraryMember(
                UUID.randomUUID().toString(),
                firstName,
                lastName,
                phone,
                street,
                city,
                state,
                zip);
        ValidatorFactory.getValidator(LibraryMember.class).validate(libraryMember);
        return (LibraryMember) RepositoryFactory.getRepository(LibraryMember.class).save(libraryMember);
    }

    public LibraryMember editLibraryMember(
            String id,
            String firstName,
            String lastName,
            Integer phone,
            String street,
            String city,
            String state,
            Integer zip) {
        LibraryMember libraryMember = (LibraryMember) RepositoryFactory.getRepository(LibraryMember.class).findById(id);
        libraryMember.setFirstName(firstName);
        libraryMember.setLastName(lastName);
        libraryMember.setPhone(phone);
        libraryMember.setAddress(new Address(street, city, state, zip));

        return (LibraryMember) RepositoryFactory.getRepository(LibraryMember.class).save(libraryMember);
    }

    public LibraryMember searchMemberByID(String id) {
        return (LibraryMember) RepositoryFactory.getRepository(LibraryMember.class).findById(id);
    }
}
