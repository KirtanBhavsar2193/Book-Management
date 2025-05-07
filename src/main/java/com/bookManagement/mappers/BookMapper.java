package com.bookManagement.mappers;

import com.bookManagement.models.BookInput;
import com.bookManagement.models.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "bookName", source = "bookName")
    @Mapping(target = "author", source = "author")
    @Mapping(target = "publisher", source = "publisher")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "bookDescription", source = "bookDescription")
    @Mapping(target = "pages", source = "pages")
    Book bookInputToBook(BookInput bookInput);
}
