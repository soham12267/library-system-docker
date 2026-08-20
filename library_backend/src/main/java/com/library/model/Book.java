package com.library.model;


public class Book {
    private int bookId;
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book() {
    }

    public Book(int bookId, String title, String author, String isbn, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    // Use this constructor when creating a new book (no ID yet, defaults to available)
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Book{id=" + bookId + ", title='" + title + "', author='" + author +
               "', isbn='" + isbn + "', available=" + available + "}";
    }
}
