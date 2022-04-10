package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuhtorDao {

    Author getById(Long id);

    Author findAuthorByName(String firstname, String lastName);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthorById(Long id);

    List<Author> findAll();
    List<Author> listAuthorByLastNameLike(String lastName);
    Author findAuthorByNameCriteria(String craing,String walls);
    Author findAuthorByNameNative(String fistName,String lastName);

}
