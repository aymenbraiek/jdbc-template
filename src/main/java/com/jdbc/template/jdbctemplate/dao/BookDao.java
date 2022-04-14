package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Book;

import java.util.List;

public interface BookDao {

    Book getById(Long id);
    Book findBookByTitle(String title);
    Book findBookByTitleCriteria(String clean_code);
    Book saveNewBook(Book bo);
    Book updateBook(Book bo);
    void deleteBookById(Long id);
    List<Book> findAll();
}
