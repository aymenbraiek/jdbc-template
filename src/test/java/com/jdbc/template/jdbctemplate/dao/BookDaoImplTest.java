package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("qa")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.jdbc.template.jdbctemplate.dao"})
class BookDaoImplTest {
    @Autowired
    BookDao bookDao;

    @Test
    void getById() {
    }

    @Test
    void findBookByTitle() {
    }

    @Test
    void findBookByTitleCriteria() {
        Book book = bookDao.findBookByTitleCriteria("Clean Code");
        assertThat(book).isNotNull();
    }

    @Test
    void saveNewBook() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBookById() {
    }

    @Test
    void findAll() {
    }
}