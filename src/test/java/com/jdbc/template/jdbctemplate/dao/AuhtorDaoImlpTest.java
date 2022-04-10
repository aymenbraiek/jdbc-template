package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("qa")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.jdbc.template.jdbctemplate"})
class AuhtorDaoImlpTest {

    @Autowired
    AuhtorDao auhtorDao;

    @Test
    void getById() {
        Author author= auhtorDao.getById(1L);
        assertThat(author.getId()).isNotNull();

    }

    @Test
    void findAuthorByName() {
        Author author =auhtorDao.findAuthorByName("aymen","braiek");
        assertThat(author).isNotNull();
    }

    @Test
    void saveNewAuthor() {
    }

    @Test
    void updateAuthor() {
    }

    @Test
    void deleteAuthorById() {
    }
}