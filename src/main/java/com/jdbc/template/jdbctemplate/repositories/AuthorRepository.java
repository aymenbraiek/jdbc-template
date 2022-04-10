package com.jdbc.template.jdbctemplate.repositories;

import com.jdbc.template.jdbctemplate.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {

Optional<Author> findAuthorByFirstNameAndAndLastName(String fistName, String lastName);
}
