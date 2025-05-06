package com.bookManagement.controllers;

import com.bookManagement.entities.Book;
import com.bookManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @MutationMapping("addBook")
    public Book addBook(@Argument BookInput bookInput) {
        Book book = new Book();
        book.setBookName(bookInput.getBookName());
        book.setAuthor(bookInput.getAuthor());
        book.setPrice(bookInput.getPrice());
        book.setBookDescription(bookInput.getBookDescription());
        book.setPages(bookInput.getPages());
        book.setPublisher(bookInput.getPublisher());
        return bookService.addBook(book);
    }

    @QueryMapping("allBooks")
    public List<Book> allBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping("getBookById")
    public Book getBookById(@Argument int bookId) {
        return bookService.getBookById(bookId);
    }
}



class BookInput {
    private String bookName;
    private String author;
    private String publisher;
    private double price;
    private String bookDescription;
    private int pages;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
