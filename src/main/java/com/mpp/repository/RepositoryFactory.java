package com.mpp.repository;

import com.mpp.model.Book;
import com.mpp.model.LibraryMember;
import com.mpp.serializer.BookSerializer;

final public class RepositoryFactory {

    private RepositoryFactory() {
    }

    public static Repository<LibraryMember> getLibraryMemberRepository() {
        return new LibraryMemberRepository(new BookSerializer());
    }

    public static Repository<Book> getBookRepository() {
        return new BookRepository(new BookSerializer());
    }

}
