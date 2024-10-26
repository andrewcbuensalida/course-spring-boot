package com.devtiro.database;

import org.springframework.context.ApplicationContext;

import com.devtiro.database.model.Book;
import com.devtiro.database.repository.impl.BookDaoImpl;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class DatabaseApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(DatabaseApplication.class, args);

    Book book = context.getBean(Book.class);
    book.setIsbn("123456789");
    book.setTitle("Spring Boot in Action");
    book.setAuthorId(1L);

    BookDaoImpl bookRepository = context.getBean(BookDaoImpl.class);
    bookRepository.create(book);

    Optional<Book> foundBook = bookRepository.findOne("123456789");
    log.info("Found book: " + foundBook);
  }
}
