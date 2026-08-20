package com.library.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Transaction;
import com.library.util.DBConnection;

public class TransactionDAOImpl implements TransactionDAO {

    @Override
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (book_id, member_id, issue_date, due_date, return_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, transaction.getBookId());
            ps.setInt(2, transaction.getMemberId());
            ps.setDate(3, Date.valueOf(transaction.getIssueDate()));
            ps.setDate(4, Date.valueOf(transaction.getDueDate()));
            ps.setDate(5, transaction.getReturnDate() != null ? Date.valueOf(transaction.getReturnDate()) : null);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getTransactionsByMember(int memberId) {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, memberId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Transaction getActiveTransactionForBook(int bookId) {
        String sql = "SELECT * FROM transactions WHERE book_id = ? AND return_date IS NULL";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, bookId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void markReturned(int transactionId, LocalDate returnDate) {
        String sql = "UPDATE transactions SET return_date = ? WHERE transaction_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(returnDate));
            ps.setInt(2, transactionId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Transaction mapRow(ResultSet rs) throws SQLException {
        Date returnDate = rs.getDate("return_date");
        return new Transaction(
            rs.getInt("transaction_id"),
            rs.getInt("book_id"),
            rs.getInt("member_id"),
            rs.getDate("issue_date").toLocalDate(),
            rs.getDate("due_date").toLocalDate(),
            returnDate != null ? returnDate.toLocalDate() : null
        );
    }
}
