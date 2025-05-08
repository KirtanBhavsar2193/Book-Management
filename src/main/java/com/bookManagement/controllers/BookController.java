package com.bookManagement.controllers;

import com.bookManagement.mappers.BookMapper;
import com.bookManagement.models.entities.Book;
import com.bookManagement.models.BookInput;
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

    @Autowired
    private BookMapper bookMapper;

    @MutationMapping("addBook")
    public Book addBook(@Argument BookInput bookInput) {

        Book book = bookMapper.bookInputToBook(bookInput);
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