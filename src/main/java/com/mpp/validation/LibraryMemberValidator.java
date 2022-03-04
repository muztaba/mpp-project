package com.mpp.validation;

import com.mpp.exception.ValidationException;
import com.mpp.model.Address;
import com.mpp.model.LibraryMember;

public class LibraryMemberValidator implements IValidator {
    @Override
    public void validate(Object obj) throws ValidationException {
        LibraryMember libraryMember = (LibraryMember) obj;
        ValidatorUtility.isValidString(libraryMember.getFirstName());
        ValidatorUtility.isValidString(libraryMember.getLastName());
        ValidatorFactory.getValidator(Address.class).validate(libraryMember.getAddress());
    }
}
