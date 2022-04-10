package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@Component
public class AuhtorDaoImlp implements AuhtorDao {

    // EntityManagerFactory
    // DI
    /*
    DI With constructor and used private final
     */
    private final EntityManagerFactory emf;

    public AuhtorDaoImlp(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public Author getById(Long id) {
        return getEntityManager().find(Author.class, id);

    }

    @Override
    public Author findAuthorByName(String firstname, String lastName) {
        TypedQuery<Author> query = getEntityManager().createQuery("SELECT a from Author a where a.firstName = :firstname and a.lastName= :lastName", Author.class);
        query.setParameter("firstname", firstname);
        query.setParameter("lastName", lastName);
        return query.getSingleResult();
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


    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }


    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
