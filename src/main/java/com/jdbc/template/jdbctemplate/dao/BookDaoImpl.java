package com.jdbc.template.jdbctemplate.dao;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.awt.print.Book;
import java.util.List;

@Component
public class BookDaoImpl  implements BookDao{

    private final EntityManagerFactory emf;

    public BookDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book findBookByTitle(String title) {
        return null;
    }
    @Override
    public Book findBookByTitleCriteria(String title) {

        EntityManager em=getEntityManager();
        try{
            CriteriaBuilder criteriaBuilder = emf.getCriteriaBuilder();
            CriteriaQuery<Book> ciCriteriaQuery=criteriaBuilder.createQuery(Book.class);
            Root<Book> root=ciCriteriaQuery.from(Book.class);
            ParameterExpression<String> titleParam=criteriaBuilder.parameter(String.class);
            Predicate titlePredicate =criteriaBuilder.equal(root.get("title"),titleParam);
            ciCriteriaQuery.select(root).where(titlePredicate);
            TypedQuery<Book> typedQuery=em.createQuery(ciCriteriaQuery);
            typedQuery.setParameter(titleParam,title);
            return typedQuery.getSingleResult();
        }finally {
            em.close();
        }

    }

    @Override
    public Book saveNewBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
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
