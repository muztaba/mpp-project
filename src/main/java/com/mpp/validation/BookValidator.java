package com.mpp.validation;

import com.mpp.exception.ValidationException;
import com.mpp.model.Author;
import com.mpp.model.Book;

public class BookValidator implements IValidator {
    @Override
    public void validate(Object obj) throws ValidationException {
        // TODO: implement book input validation
        Book book = (Book) obj;
        ValidatorUtility.isValidString(book.getTitle());
        ValidatorUtility.isValidISBN(book.getIsbn());
        for(Author author: book.getAuthors()){
            ValidatorUtility.isValidString(author.getFirstName());
        }

    }
}
