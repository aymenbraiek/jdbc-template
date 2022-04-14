package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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
        EntityManager entityManager = getEntityManager();
        Author author = getEntityManager().find(Author.class, id);
        entityManager.close();
        return author;
    }

    @Override
    public Author findAuthorByName(String firstname, String lastName) {
        EntityManager em = getEntityManager();
        TypedQuery<Author> typedQuery = em.createQuery("select a from Author a where a.firstName =:first_name and a.lastName=: last_name", Author.class);
        typedQuery.setParameter("first_name", firstname);
        typedQuery.setParameter("last_name", lastName);

        System.out.println(firstname + "--------" + lastName);
        Author author = typedQuery.getSingleResult();
        em.close();
        return author;
    }

    @Override
    public Author saveNewAuthor(Author author) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(author);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return author;
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
        EntityManager em =getEntityManager();
            try {
                TypedQuery<Author> typedQuery = em.createNamedQuery("author_find_all",Author.class);
                return  typedQuery.getResultList();
        } finally {
            em.close();
        }
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
        EntityManager entityManager=getEntityManager();
        try{
            Query query=entityManager.createNativeQuery("SELECT * FROM author a where a.first_name = ? and a.last_name = ?",Author.class);
            query.setParameter(1,fistName);
            query.setParameter(2,lastName);
            Author author= (Author) query.getSingleResult();
            return  author;
        }finally {
            entityManager.close();
        }


    }


    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }


    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
