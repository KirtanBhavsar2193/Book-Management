package com.bookManagement.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookInput {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int bookId;
    private String bookName;
    private String author;
    private String publisher;
    private double price;
    private String bookDescription;
    private int pages;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

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