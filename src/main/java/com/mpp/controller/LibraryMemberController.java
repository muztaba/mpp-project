package com.mpp.controller;

import com.mpp.exception.ValidationException;
import com.mpp.model.Address;
import com.mpp.model.CheckoutEntry;
import com.mpp.model.CheckoutRecord;
import com.mpp.model.LibraryMember;
import com.mpp.repository.LibraryMemberRepository;
import com.mpp.repository.RepositoryFactory;
import com.mpp.validation.ValidatorFactory;

import java.util.List;
import java.util.Collection;
import java.util.UUID;

public class LibraryMemberController implements DomainController {
    private final LibraryMemberRepository libraryMemberRepository;

    public LibraryMemberController(LibraryMemberRepository libraryMemberRepository) {
        this.libraryMemberRepository = libraryMemberRepository;
    }

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
        libraryMemberRepository.save(libraryMember);
        return libraryMember;
    }

    public LibraryMember editLibraryMember(
            String id,
            String firstName,
            String lastName,
            Integer phone,
            String street,
            String city,
            String state,
            Integer zip) throws ValidationException {
        LibraryMember libraryMember = libraryMemberRepository.findById(id);
        libraryMember.setFirstName(firstName);
        libraryMember.setLastName(lastName);
        libraryMember.setPhone(phone);
        libraryMember.setAddress(new Address(street, city, state, zip));
        System.out.println(libraryMember);
        ValidatorFactory.getValidator(LibraryMember.class).validate(libraryMember);
        return libraryMemberRepository.save(libraryMember);
    }

    public LibraryMember searchMemberByID(String id) {
        return libraryMemberRepository.findById(id);
    }

    public Collection<LibraryMember> getAllMember(){
        return libraryMemberRepository.findAll();
    }




    public List<CheckoutEntry> getCheckoutEntriesByLibraryMember(String id) {
        LibraryMember libraryMember = libraryMemberRepository.findById(id);
        return libraryMember.getCheckoutRecord().getCheckoutEntries();
    }


    public List<CheckoutEntry> getAllCheckoutEntryByLibraryMember(String memberId) {
        return libraryMemberRepository.findById(memberId)
                .getCheckoutRecord()
                .getCheckoutEntries();
    }
}
