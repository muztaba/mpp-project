package com.mpp.validation;

import com.mpp.exception.ValidationException;

import java.util.Objects;

public class ValidatorUtility {

    public static boolean isValidString(String input) throws ValidationException {
        if (input == null || input.equals("") || Objects.equals(input, "null")){
            throw new ValidationException(input + "is a wrong input!");
        }
        return true;
    }


    public static void isValidISBN(String isbn) {
    }
}
