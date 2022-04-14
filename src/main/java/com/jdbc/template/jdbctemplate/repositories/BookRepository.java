package com.jdbc.template.jdbctemplate.repositories;

import com.jdbc.template.jdbctemplate.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
