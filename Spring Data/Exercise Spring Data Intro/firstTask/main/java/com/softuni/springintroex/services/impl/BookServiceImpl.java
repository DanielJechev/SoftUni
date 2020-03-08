package com.softuni.springintroex.services.impl;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.entities.*;
import com.softuni.springintroex.repositories.BookRepository;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.services.BookService;
import com.softuni.springintroex.services.CategoryService;
import com.softuni.springintroex.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final Util util;

@Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService, AuthorService authorService, Util util) {
    this.bookRepository = bookRepository;
    this.categoryService = categoryService;
    this.authorService = authorService;
    this.util = util;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count()!=0) {
            return;
        }
        String[] fileContent=this.util.readFileContent(GlobalConstants.BOOKS);
        Arrays.stream(fileContent).forEach(r->{
            String[] params=r.split("\\s+");
            Author author=this.getRandomAuthor();
            EditionType editionType=EditionType.values()[Integer.parseInt(params[0])];
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate realeseDate=LocalDate.parse(params[1],formatter);
            int copies=Integer.parseInt(params[2]);
            BigDecimal price=new BigDecimal(params[3]);
            AgeRestriction ageRestriction=AgeRestriction.values()[Integer.parseInt(params[4])];
            String title=this.getTitle(params);
            Set<Category> categories=this.getRandomCategories();
            Book book=new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(realeseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);
            this.bookRepository.saveAndFlush(book);
        });

    }
    @Override
    public List<Book> findAllByAuthorFirstNameAndAuthorLastName(String firstName, String lastName) {
        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);

    }
    @Override
    public List<Object[]> getAllAuthorsOrOrderByBooksCount() {
        return this.bookRepository.getAllAuthorsOrOrderByBooksCount();
    }

    @Override
    public List<Book> getAllBookAfter2000() {
        return this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));
        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());

    }


    private Set<Category> getRandomCategories() {
    Set<Category> result=new HashSet<>();
    Random random=new Random();
    int bound=random.nextInt(3)+1;
        for (int i = 1; i <=bound ; i++) {
            int categoryId=random.nextInt(8)+1;
        result.add(this.categoryService.getCategoryById((long) categoryId));
        }
        return result;
    }

    private String getTitle(String[] params) {
    StringBuilder sb=new StringBuilder();
        for (int i = 5; i <params.length ; i++) {
            sb.append(params[i]).append(" ");
        }
        return sb.toString().trim();
    }

    private Author getRandomAuthor() {
        Random random=new Random();
        int randomId=random.nextInt(this.authorService.getAllAuthorsCount())+1;
        return this.authorService.findAuthorById((long) randomId);
    }
}
