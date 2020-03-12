package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.Book;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;
 List<Book> getAgeRestriction(String ageRestriction);
 List<Book> getGolden();
 List<Book> getTitleAndPrice();
 List<Book> getNotReleased(int year);
 List<Book> getReleasedBefore(String date);
 List<Book> getTitleContain(String alfa);
 List<Book> getSearchTitle(String title);
 void getBooksCountByMinLength() throws IOException;
 void getAuthorAndCopies();
 void reducedBook() throws IOException;
}
