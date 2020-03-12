package com.softuni.springintroex.services.impl;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.entities.Author;
import com.softuni.springintroex.entities.Category;
import com.softuni.springintroex.repositories.AuthorRepository;
import com.softuni.springintroex.services.AuthorService;
import com.softuni.springintroex.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final Util fileUtil;
@Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, Util fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count()!=0) {
            return;
        }
        String[] fileContent=this.fileUtil.readFileContent(GlobalConstants.AUTHORS);
        Arrays.stream(fileContent).forEach(
                r->{String [] params=r.split("\\s+");
                Author author=new Author(params[0],params[1]);
            this.authorRepository.saveAndFlush(author);
        });
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorsByCountOfBooks();
    }

    @Override
    public Author findBookFromAuthor() {
        return null;
    }

    @Override
    public List<Author> getEndWith(String alfa) {
        return this.authorRepository.findAllByFirstNameEndingWith(alfa);
    }


}
