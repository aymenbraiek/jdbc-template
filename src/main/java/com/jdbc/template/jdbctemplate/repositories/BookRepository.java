package com.jdbc.template.jdbctemplate.repositories;

import com.jdbc.template.jdbctemplate.domain.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<book,Long> {
}
