package com.devtiro.database.repository;

import com.devtiro.database.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);

    List<Author> find();


    void update(long id, Author author);

    void delete(long id);
}
