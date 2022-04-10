package com.jdbc.template.jdbctemplate.repositories;

import com.jdbc.template.jdbctemplate.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
