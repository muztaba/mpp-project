package com.mpp.validation;

import com.mpp.exception.ValidationException;
import com.mpp.model.Address;
import com.mpp.model.Author;
import com.mpp.model.LibraryMember;

public class AuthorValidator implements IValidator{
    @Override
    public void validate(Object obj) throws ValidationException {
        Author author = (Author) obj;
        ValidatorUtility.isValidString(author.getFirstName());
        ValidatorUtility.isValidString(author.getLastName());
        ValidatorUtility.isValidString(author.getBio());
        ValidatorFactory.getValidator(Address.class).validate(author.getAddress());
    }
}
