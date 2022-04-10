package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;
import com.jdbc.template.jdbctemplate.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class AuhtorDaoImlp implements AuhtorDao {

    private final AuthorRepository authorRepository;

    public AuhtorDaoImlp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Optional<Author> getById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent())

            return author;
        return null;
    }

    @Override
    public Author findAuthorByName(String firstname, String lastName) {
        return authorRepository.findAuthorByFirstNameAndAndLastName(firstname,lastName).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {

    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public List<Author> listAuthorByLastNameLike(String lastName) {
        return null;
    }

    @Override
    public Author findAuthorByNameCriteria(String craing, String walls) {
        return null;
    }

    @Override
    public Author findAuthorByNameNative(String fistName, String lastName) {
        return null;
    }


}
