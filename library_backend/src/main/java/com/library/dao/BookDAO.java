package com.library.dao;

import java.util.List;
import com.library.model.Book;

public interface BookDAO {
    void addBook(Book book);
    Book getBookById(int bookId);
    List<Book> getAllBooks();
    List<Book> searchByTitle(String title);
    void updateBook(Book book);
    void deleteBook(int bookId);
    void updateAvailability(int bookId, boolean available);
}
