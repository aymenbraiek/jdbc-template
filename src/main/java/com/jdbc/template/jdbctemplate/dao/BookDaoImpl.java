package com.jdbc.template.jdbctemplate.dao;

import com.jdbc.template.jdbctemplate.domain.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Component
public class BookDaoImpl  implements BookDao{

    private final EntityManagerFactory emf;

    public BookDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public Book getById(Long id) {
        EntityManager em=getEntityManager();
        Book book=em.find(Book.class,id);
        em.close();
        return book;
    }

    @Override
    public Book findBookByTitle(String title) {
        return null;
    }
    @Override
    public Book findBookByTitleCriteria(String title) {

        EntityManager em = getEntityManager();

        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

            Root<Book> root = criteriaQuery.from(Book.class);

            ParameterExpression<String> titleParam = criteriaBuilder.parameter(String.class);

            Predicate titlePredicate = criteriaBuilder.equal(root.get("title"), titleParam);

            criteriaQuery.select(root).where(titlePredicate);

            TypedQuery<Book> typedQuery = em.createQuery(criteriaQuery);
            typedQuery.setParameter(titleParam, title);

            return typedQuery.getSingleResult();
        } finally {
            em.close();;
        }

    }

    @Override
    public Book saveNewBook(Book bo) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(bo);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return bo;
    }

    @Override
    public Book updateBook(Book bo) {
        return null;
    }


    @Override
    public void deleteBookById(Long id) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }


    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
