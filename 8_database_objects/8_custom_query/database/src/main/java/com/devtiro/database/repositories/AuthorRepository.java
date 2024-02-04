package com.devtiro.database.repositories;

import com.devtiro.database.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    // spring data jpa is able to assume the sql query based on this ageLessThan method name
    Iterable<Author> ageLessThan(int age);

}
