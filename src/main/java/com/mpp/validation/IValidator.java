package com.mpp.validation;

import com.mpp.exception.ValidationException;

public interface IValidator {
    public void validate(Object obj) throws ValidationException;
}
