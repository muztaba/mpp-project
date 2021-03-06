package com.mpp.controller;

import com.mpp.exception.BookCopyNotAvailableException;
import com.mpp.model.*;
import com.mpp.repository.CheckoutRecordRepository;
import com.mpp.repository.RepositoryFactory;
import com.mpp.utils.ApplicationContext;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class CheckoutRecordController implements DomainController {
    private final CheckoutRecordRepository checkoutRecordRepository;

    public CheckoutRecordController(CheckoutRecordRepository checkoutRecordRepository) {
        this.checkoutRecordRepository = checkoutRecordRepository;
    }

    public CheckoutRecord checkOutBooksForLibraryMembers(String libraryMemberId, String isbn) throws BookCopyNotAvailableException {
        // get libraryMember by id
        LibraryMember libraryMember = RepositoryFactory.libraryMemberRepository().findById(libraryMemberId);
        // get book by isbn
        Book book = RepositoryFactory.bookRepository().findByIsbn(isbn);
        // check if a copy of the book is available
        BookCopy bookCopy = RepositoryFactory.bookRepository().findFirstAvailableBookCopy(book);
        if (bookCopy == null) {
            throw new BookCopyNotAvailableException();
        }
        // create a CheckoutEntry
        CheckoutEntry checkoutEntry = new CheckoutEntry(bookCopy, new Date(), getDueDate(book), ApplicationContext.getUser(), libraryMember);
        // set availability to false to the bookCopy
        bookCopy.setAvailable(false);
        // create a checkoutRecord
        CheckoutRecord checkoutRecord = libraryMember.getCheckoutRecord() == null ? new CheckoutRecord() : libraryMember.getCheckoutRecord();
        checkoutRecord.addCheckoutEntry(checkoutEntry);
        libraryMember.setCheckoutRecord(checkoutRecord);
        return checkoutRecordRepository.save(checkoutRecord);
    }

    public CheckoutRecord createOverdueCheckoutRecord(String libraryMemberId, String isbn) throws BookCopyNotAvailableException {
        // get libraryMember by id
        LibraryMember libraryMember = RepositoryFactory.libraryMemberRepository().findById(libraryMemberId);
        // get book by isbn
        Book book = RepositoryFactory.bookRepository().findByIsbn(isbn);
        // check if a copy of the book is available
        BookCopy bookCopy = RepositoryFactory.bookRepository().findFirstAvailableBookCopy(book);
        if (bookCopy == null) {
            throw new BookCopyNotAvailableException();
        }
        // create a CheckoutEntry
        CheckoutEntry checkoutEntry = new CheckoutEntry(bookCopy, getOldDay(), getOldDueDate(book), ApplicationContext.getUser(), libraryMember);
        // set availability to false to the bookCopy
        bookCopy.setAvailable(false);
        // create a checkoutRecord
        CheckoutRecord checkoutRecord = libraryMember.getCheckoutRecord() == null ? new CheckoutRecord() : libraryMember.getCheckoutRecord();
        checkoutRecord.addCheckoutEntry(checkoutEntry);
        libraryMember.setCheckoutRecord(checkoutRecord);
        return checkoutRecordRepository.save(checkoutRecord);
    }
    private Date getOldDay() {
        LocalDate oldDate = LocalDate.of( 2022 , 1 , 15 );
        return java.util.Date.from(oldDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
    private Date getOldDueDate(Book book) {
        LocalDate oldDate = LocalDate.of( 2022 , 1 , 15 );
        LocalDate dueDate = oldDate.plusDays(book.getBorrowDurationInDays());
        return java.util.Date.from(dueDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    private Date getDueDate(Book book) {
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(book.getBorrowDurationInDays());
        return java.util.Date.from(dueDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public List<CheckoutEntry> getAllCheckoutEntries() {
        return checkoutRecordRepository.findAll()
                .stream()
                .flatMap(it -> it.getCheckoutEntries().stream())
                .toList();
    }

    public List<CheckoutEntry> getAllOverdueEntries() {
        return checkoutRecordRepository.findAll()
                .stream()
                .flatMap(it -> it.getCheckoutEntries().stream())
                .filter(it -> {
                    Date dueDate = it.getDueDate();
                    return dueDate.before(new Date());
                })
                .peek(it -> {
                    Date dueDate = it.getDueDate();
                    long between = ChronoUnit.DAYS.between(new Date().toInstant(), dueDate.toInstant());
                    it.setFine(((float) (between * .25)));
                })
                .toList();
    }

    public List<Book> getAllOverDueBooks() {
        return getAllCheckoutEntries()
                .stream()
                .map(CheckoutEntry::getBookCopy)
                .map(BookCopy::getBook)
                .toList();
    }

    public CheckoutEntry findLibraryMemberByBookCopy(String bookCopyId) {
        for (CheckoutRecord r : checkoutRecordRepository.findAll()) {
            for (CheckoutEntry e : r.getCheckoutEntries()) {
                if (e.getBookCopy().getID().equals(bookCopyId)) {
                    return e;
                }
            }
        }
        return null;
    }


}
