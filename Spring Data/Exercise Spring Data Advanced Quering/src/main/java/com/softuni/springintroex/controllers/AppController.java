package com.softuni.springintroex.controllers;

import com.softuni.springintroex.entities.Book;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
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
 BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


 //1.Books Titles by Age Restriction
   // this.bookService.getAgeRestriction(reader.readLine()).stream().
      //       map(Book::getTitle).forEach(System.out::println);


//2.Golden Books
//this.bookService.getGolden().stream().map(Book::getTitle).forEach(System.out::println);

//3.Books by Price
     //   List<Book> bookInfo = bookService.getTitleAndPrice();
       // for (Book book:bookInfo) {
        //    System.out.println(book.getTitle()+ " - "+"$"+book.getPrice() );
        //}

        //4.Not Released Books
      //  this.bookService.getNotReleased(Integer.parseInt(reader.readLine())).stream().
        //       map(Book::getTitle).forEach(System.out::println);

      //  5.Books Released Before Date
//this.bookService.getReleasedBefore(reader.readLine()).stream().forEach(
  //      b->{
    //        System.out.printf("%s %s %.2f%n",b.getTitle(),b.getEditionType(),b.getPrice()); });

        //6.Authors Search
       // this.authorService.getEndWith(reader.readLine()).stream().forEach(a->{
          //  System.out.println(a.getFirstName() +" " + a.getLastName());
        //});

        //7.Books Search
  // this.bookService.getTitleContain(reader.readLine()).stream().map(Book::getTitle).forEach(System.out::println);

        //8.Book Titles Search
//this.bookService.getSearchTitle(reader.readLine()).stream().forEach(b->{
  //  System.out.println(b.getTitle() +"(" +b.getAuthor().getFirstName() +" " + b.getAuthor().getLastName()+")"); });

        //9.Count Books
        //this.bookService.getBooksCountByMinLength();


        //10.Total Book Copies
       // this.bookService.getAuthorAndCopies();

        //11.	Reduced Book
  //this.bookService.reducedBook();
    }
}
