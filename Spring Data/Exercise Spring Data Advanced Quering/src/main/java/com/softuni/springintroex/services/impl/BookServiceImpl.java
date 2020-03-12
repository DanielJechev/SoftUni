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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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
    public List<Book> getAgeRestriction(String ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()));
    }

    @Override
    public List<Book> getGolden() {
        return this.bookRepository.getAllGoldenBooks();
    }

    @Override
    public List<Book> getTitleAndPrice() {
        return this.bookRepository.getBookByPrice();
    }

    @Override
    public List<Book> getNotReleased(int year) {
    LocalDate before=LocalDate.of( year,1,1);
    LocalDate after=LocalDate.of( year,12,31);
        return this.bookRepository.getNotReleasedBooks(before,after);
    }

    @Override
    public List<Book> getReleasedBefore(String date) {
        LocalDate before=LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this.bookRepository.getReleasedBooksBefore(before);
    }

    @Override
    public List<Book> getTitleContain(String alfa) {
        return this.bookRepository.findAllByTitleContains(alfa.toUpperCase());
    }

    @Override
    public List<Book> getSearchTitle(String title) {
        return this.bookRepository.getBooksByAuthorLastNameStartsWith(title.toUpperCase());
    }

    @Override
    public void getBooksCountByMinLength() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int minLength = Integer.parseInt(reader.readLine());

        int bookCount = bookRepository
                .countBooksByTitle(minLength);
        if (bookCount == 0) {
            System.err.printf("Nothing found with %d characters length!%n", minLength);
            return;
        }
        System.out.printf("There are %d books with longer title than %d symbols%n",
                bookCount, minLength);
    }

    @Override
    public void getAuthorAndCopies() {
        List<Object[]> columns = bookRepository.getBooksCopiesWithAuthorNames();
        for (Object[] column : columns) {
            System.out.printf("%s %s - %d%n",
                    String.valueOf(column[0]),
                    String.valueOf(column[1]),
                    Integer.parseInt(String.valueOf(column[2])));
        }
    }

    @Override
    public void reducedBook() throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String input=reader.readLine();
        List<Object[]> columns = bookRepository.getBooksInfo(input);
        for (Object[] values : columns) {
            System.out.printf("%s %s %s %.2f%n",
                    String.valueOf(values[0]),
                    String.valueOf(values[1]),
                    String.valueOf(values[2]),
                    Double.parseDouble(String.valueOf(values[3])));
        }


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
