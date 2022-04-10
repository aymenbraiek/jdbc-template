package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;

import java.util.Optional;

public interface AuhtorDao {

    Author getById(Long id);

    Author findAuthorByName(String firstname, String lastName);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthorById(Long id);

}
