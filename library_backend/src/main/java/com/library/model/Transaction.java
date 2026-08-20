package com.library.model;

import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private int bookId;
    private int memberId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate; // null until the book is returned

    public Transaction() {
    }

    public Transaction(int transactionId, int bookId, int memberId,
                        LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public Transaction(int bookId, int memberId, LocalDate issueDate, LocalDate dueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return "Transaction{id=" + transactionId + ", bookId=" + bookId + ", memberId=" + memberId +
               ", issueDate=" + issueDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + "}";
    }
}
