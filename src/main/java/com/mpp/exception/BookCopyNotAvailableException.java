package com.mpp.exception;

public class BookCopyNotAvailableException extends Throwable {
    public BookCopyNotAvailableException(String s) {
        super(s);
    }

    public BookCopyNotAvailableException() {
        super();
    }
}
