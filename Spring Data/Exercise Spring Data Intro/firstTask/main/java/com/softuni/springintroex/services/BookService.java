package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.Book;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;
List<Book> getAllBookAfter2000();
Set<String> getAllAuthorsWithBookBefore();
    List<Object[]>  getAllAuthorsOrOrderByBooksCount();
    List<Book> findAllByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);
}
