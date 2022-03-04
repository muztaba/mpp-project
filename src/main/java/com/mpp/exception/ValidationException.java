package com.mpp.exception;

public class ValidationException extends Exception {
    public ValidationException(String s) {
        super(s);
    }

    public ValidationException() {
        super();
    }
}
