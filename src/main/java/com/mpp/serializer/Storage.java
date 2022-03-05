package com.mpp.serializer;

import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.model.CheckoutRecord;
import com.mpp.model.LibraryMember;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Storage implements Serializable {

//    INSTANCE;

    public Map<String, Book> books = new HashMap<>();
    public Map<String, Author> authors = new HashMap<>();
    public Map<String, LibraryMember> libraryMembers = new HashMap<>();
    public Map<String, CheckoutRecord> checkoutRecords = new HashMap<>();

}
