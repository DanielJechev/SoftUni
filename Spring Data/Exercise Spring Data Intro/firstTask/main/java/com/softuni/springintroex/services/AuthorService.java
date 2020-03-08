package com.softuni.springintroex.services;

import com.softuni.springintroex.entities.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;
  int getAllAuthorsCount();
  Author findAuthorById(Long id);
}
