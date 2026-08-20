package com.library.controller;

import org.springframework.web.bind.annotation.*;
import com.library.model.Book;
import com.library.dao.BookDAO;
import com.library.dao.BookDAOImpl;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // Default Vite React port
public class BookController {

    // Reusing your exact database logic!
    private BookDAO bookDAO = new BookDAOImpl();

    // When React asks for books, this runs. (Replaces Option 2)
    @GetMapping("/books")
    public List getAllBooks() {
        // Spring Boot magically converts this Java List into JSON for React!
        return bookDAO.getAllBooks(); 
    }

    // When React sends a new book form, this runs. (Replaces Option 1)
    @PostMapping("/books")
    public String addBook(@RequestBody Book book) {
        // The @RequestBody annotation automatically unpacks the JSON into your Book model
        bookDAO.addBook(book);
        return "Book added successfully";
    }
}