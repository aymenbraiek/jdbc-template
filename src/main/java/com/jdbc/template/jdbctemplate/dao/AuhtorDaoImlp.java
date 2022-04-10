package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuhtorDaoImlp implements AuhtorDao{

   //jdbc template
    // DI
    /*
    DI With constructor and used private final
     */

    private final JdbcTemplate jdbcTemplate;

    public AuhtorDaoImlp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Author getById(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM author where id=?",getRowMapper(),id);
    }

    @Override
    public Author findAuthorByName(String firstname, String lastName) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM author where first_name= ? and last_name =?  ",getRowMapper(),firstname,lastName);
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


    private RowMapper<Author> getRowMapper(){
        return new AuthorMapper();
    }
}
