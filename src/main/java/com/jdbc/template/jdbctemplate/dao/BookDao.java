package com.jdbc.template.jdbctemplate.dao;

import java.awt.print.Book;
import java.util.List;

public interface BookDao {

    Book getById(Long id);
    Book findBookByTitle(String title);
    Book findBookByTitleCriteria(String clean_code);
    Book saveNewBook(Book book);
    Book updateBook(Book book);
    void deleteBookById(Long id);
    List<Book> findAll();
}
