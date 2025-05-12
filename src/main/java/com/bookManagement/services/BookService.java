package com.bookManagement.services;

import com.bookManagement.exceptions.DataNotFoundException;
import com.bookManagement.mappers.BookMapper;
import com.bookManagement.models.BookInput;
import com.bookManagement.models.entities.Book;
import com.bookManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public Book addBook(BookInput bookInput) {
        Book book = bookMapper.bookInputToBook(bookInput);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(() ->
                new DataNotFoundException("Book not found at ID :- " + bookId));
    }

    public Book updateBook(int bookId, BookInput bookInput) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new DataNotFoundException("Book not found at ID :- " + bookId));

//        bookMapper.updateBookFromBookInput(bookInput, book);
        book.setBookName(bookInput.getBookName());
        book.setAuthor(bookInput.getAuthor());
        book.setPublisher(bookInput.getPublisher());
        book.setPrice(bookInput.getPrice());
        book.setBookDescription(bookInput.getBookDescription());
        book.setPages(bookInput.getPages());
        return bookRepository.save(book);
    }

    public String deleteBook(int bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new DataNotFoundException("Book not found at ID :- " + bookId));

        bookRepository.delete(book);

        return "Book deleted successfully" + book.getBookName();
    }
}