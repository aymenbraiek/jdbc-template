package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;
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
class AuhtorDaoImlpTest {
    @Autowired
    AuhtorDao authorDao;


    @Test
    void getById() {
        Author author = authorDao.getById(1L);

        assertThat(author).isNotNull();
    }

    @Test
    void findAuthorByName() {
    }

    @Test
    void saveNewAuthor() {
        Author author = new Author();
        author.setFirstName("Eric");
        author.setLastName("Evans");
        Author saved = authorDao.saveNewAuthor(author);

        assertThat(saved).isNotNull();
    }

    @Test
    void updateAuthor() {

    }

    @Test
    void deleteAuthorById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void listAuthorByLastNameLike() {
    }

    @Test
    void findAuthorByNameCriteria() {
        Author author = authorDao.findAuthorByNameCriteria("Craig", "Walls");

        assertThat(author).isNotNull();
    }

    @Test
    void findAuthorByNameNative() {
    }
}