package com.devtiro.database.repository;

import com.devtiro.database.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();
    void update(String isbn, Book book);

    void delete(String isbn);
}