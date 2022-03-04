package com.mpp.repository;

import com.mpp.model.Book;
import com.mpp.model.LibraryMember;
import com.mpp.serializer.BookSerializer;
import com.mpp.serializer.LibraryMemberSerializer;
import com.mpp.validation.BookValidator;
import com.mpp.validation.IValidator;
import com.mpp.validation.LibraryMemberValidator;

import java.util.HashMap;
import java.util.Map;

final public class RepositoryFactory {

    private RepositoryFactory() {
    }

    static Map<Class<? extends Object>, Repository> repositoryMap = new HashMap<Class<? extends Object>, Repository>() {{
        put(Book.class, new BookRepository(new BookSerializer()));
        put(LibraryMember.class, new LibraryMemberRepository(new LibraryMemberSerializer()));
    }};

    public static Repository getRepository(Class<? extends Object> clazz) {
        return repositoryMap.get(clazz);
    }

}
