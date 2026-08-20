package com.library.dao;

import java.time.LocalDate;
import java.util.List;
import com.library.model.Transaction;

public interface TransactionDAO {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransactionsByMember(int memberId);
    Transaction getActiveTransactionForBook(int bookId);
    void markReturned(int transactionId, LocalDate returnDate);
}
