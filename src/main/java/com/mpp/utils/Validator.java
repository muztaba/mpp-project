package com.mpp.utils;

import java.util.Objects;

public class Validator {

    public static boolean isValidString(String input) throws WrongInput {
        if (input == null || input.equals("") || Objects.equals(input, "null")){
            throw new WrongInput(input + "is a wrong input!");
        }
        return true;
    }


    public static void isValidISBN(String isbn) {
    }
}
