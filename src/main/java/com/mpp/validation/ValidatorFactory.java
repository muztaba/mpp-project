package com.mpp.validation;

import com.mpp.model.Address;
import com.mpp.model.Book;
import com.mpp.model.LibraryMember;

import java.util.HashMap;
import java.util.Map;

public final class ValidatorFactory {
    private ValidatorFactory() {}

    static Map<Class<? extends Object>, IValidator> validatorMap = new HashMap<Class<? extends Object>, IValidator>() {{
        put(Book.class, new BookValidator());
        put(LibraryMember.class, new LibraryMemberValidator());
        put(Address.class, new AddressValidator());
    }};

    public static IValidator getValidator(Class<? extends Object> clazz) {
        return validatorMap.get(clazz);
    }
}
