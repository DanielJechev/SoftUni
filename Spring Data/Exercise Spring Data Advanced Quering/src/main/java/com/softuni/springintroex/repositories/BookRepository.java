package com.softuni.springintroex.repositories;

import com.softuni.springintroex.entities.AgeRestriction;
import com.softuni.springintroex.entities.Author;
import com.softuni.springintroex.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
 @Query("select b from Book as b where b.copies<5000 and b.editionType= 2")
    List<Book> getAllGoldenBooks();
@Query("select  b from Book  as b where  b.price>40 or b.price<5")
 List<Book> getBookByPrice();
@Query("select b from Book  as b where   b.releaseDate<:before or  b.releaseDate >:after")
List<Book> getNotReleasedBooks(LocalDate before,LocalDate after);
    @Query("select b from Book  as b where   b.releaseDate<:before")
    List<Book> getReleasedBooksBefore(LocalDate before);
    List<Book> findAllByTitleContains(String alfa);
    List<Book> getBooksByAuthorLastNameStartsWith(String startStr);

    @Query("SELECT COUNT(b.id) FROM Book b WHERE length(b.title) > :minTitleLen")
    int countBooksByTitle(@Param("minTitleLen") int minTitleLen);



    @Query("select b.author.firstName , b.author.lastName,sum(b.copies) as sum_copies from Book b  group by b.author.id order by sum_copies desc ")
    List<Object[]> getBooksCopiesWithAuthorNames();
    @Query("SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book b" +
            " WHERE b.title = :title")
    List<Object[]> getBooksInfo(@Param("title") String title);
}
