package com.jdbc.template.jdbctemplate.repositories;

import com.jdbc.template.jdbctemplate.domain.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.awt.print.Book;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<book,Long> {

    // handle null
    @Nullable
    Book getByTitle(@Nullable String title);

    //Stream
    Stream<Book> findAllByTitleNotNull();

    //Native Query
    @Query(value = "SELECT * FROM Book WHERE  title = : title",nativeQuery = true)
    Book findbookByTitleNativeQuery(@Param("title") String title);


    // queryNamed
    @Query("select  b FROM Book b where b.title = :title")
    Book findbookByTitlewithQueryNamed(@Param("title") String title);
}
