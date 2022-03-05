package com.mpp.repository;

import com.mpp.model.Book;
import com.mpp.model.CheckoutRecord;
import com.mpp.serializer.ISerializer;
import com.mpp.serializer.Storage;
import com.mpp.utils.ApplicationContext;

import java.util.Map;

public class CheckoutRecordRepository extends Repository<CheckoutRecord> {

    CheckoutRecordRepository() {
        super(ApplicationContext.storage.checkoutRecords);
    }

}