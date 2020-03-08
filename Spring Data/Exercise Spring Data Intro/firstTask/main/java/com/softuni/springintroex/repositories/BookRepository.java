package com.softuni.springintroex.repositories;

import com.softuni.springintroex.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate localDate);
    List<Book> findAllByReleaseDateBefore(LocalDate date);

    @Query(value = "SELECT a.first_name, a.last_name, count(b.id) FROM books b " +
            "JOIN authors a on b.author_id = a.id " +
            "GROUP BY a.id " +
            "ORDER BY count(b.id) DESC",  nativeQuery = true)
    List<Object[]> getAllAuthorsOrOrderByBooksCount();
    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
