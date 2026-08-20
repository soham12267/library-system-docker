package com.library.controller;

import org.springframework.web.bind.annotation.*;
import com.library.model.Transaction;
import com.library.dao.TransactionDAO;
import com.library.dao.TransactionDAOImpl;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionController {

    private TransactionDAO transactionDAO = new TransactionDAOImpl();

    @PostMapping("/transactions/issue")
    public String issueBook(@RequestBody Transaction transaction) {
        // Automatically set today as the issue date, and 14 days from now as due date
        transaction.setIssueDate(LocalDate.now());
        transaction.setDueDate(LocalDate.now().plusDays(14));
        
        transactionDAO.addTransaction(transaction);
        return "Book issued successfully";
    }
}