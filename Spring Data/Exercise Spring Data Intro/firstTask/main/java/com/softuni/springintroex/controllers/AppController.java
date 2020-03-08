package com.softuni.springintroex.controllers;

import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {

private final CategoryService categoryService;
private final AuthorService authorService;
private final BookService bookService;
@Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
    this.authorService = authorService;
    this.bookService = bookService;
}

    @Override
    public void run(String... args) throws Exception {
 this.categoryService.seedCategories();
 this.authorService.seedAuthors();
 this.bookService.seedBooks();
 //ex1
 List<Book> book=this.bookService.getAllBookAfter2000();
        for (Book books:book) {
            System.out.println(books.getTitle());
        }
        // ex2
        this.bookService.getAllAuthorsWithBookBefore().forEach(System.out::println);
//ex3
        this.bookService.getAllAuthorsOrOrderByBooksCount()
                .forEach(a -> System.out.println(a[0] + " " + a[1] + " - " + a[2]));
//ex4
        String firstName = "George";
        String lastName = "Powell";
        List<Book> books = this.bookService.findAllByAuthorFirstNameAndAuthorLastName(firstName, lastName);
        books.forEach(b ->
                System.out.printf("Author: %s %s, Title: %s, Release Date: %s, Copies: %d:%n",
                        b.getAuthor().getFirstName(), b.getAuthor().getLastName(),
                        b.getTitle(), b.getReleaseDate(), b.getCopies()));


    }
}
