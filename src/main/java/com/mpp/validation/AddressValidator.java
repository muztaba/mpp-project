package com.mpp.validation;

import com.mpp.exception.ValidationException;
import com.mpp.model.Address;

public class AddressValidator implements IValidator {
    @Override
    public void validate(Object obj) throws ValidationException {
        Address address = (Address) obj;
        ValidatorUtility.isValidString(address.getCity());
        ValidatorUtility.isValidString(address.getState());
        ValidatorUtility.isValidString(address.getStreet());
    }
}
