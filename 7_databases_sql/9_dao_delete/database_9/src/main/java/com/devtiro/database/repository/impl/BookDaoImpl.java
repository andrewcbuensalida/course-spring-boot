package com.devtiro.database.repository.impl;

import com.devtiro.database.repository.BookDao;
import com.devtiro.database.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

  private final JdbcTemplate jdbcTemplate;

  public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void create(Book book) {
    System.out.println( "Creating book: " + book);
    jdbcTemplate.update(
        "INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)",
        book.getIsbn(),
        book.getTitle(),
        book.getAuthorId());
  }

  @Override
  public Optional<Book> findOne(String isbn) {
    System.out.println( "Finding book with isbn: " + isbn);
    RowMapper<Book> rowMapper = (rs, rowNum) -> Book.builder()
        .isbn(rs.getString("isbn"))
        .title(rs.getString("title"))
        .authorId(rs.getLong("author_id"))
        .build();

    // // Alternative way to create a RowMapper
    // RowMapper<Book> rowMapper = new RowMapper<>(){
    //   @Override
    //   public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
    //     return Book.builder()
    //         .isbn(rs.getString("isbn"))
    //         .title(rs.getString("title"))
    //         .authorId(rs.getLong("author_id"))
    //         .build();
    //   }
    // };
    List<Book> results = jdbcTemplate.query(
        "SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1",
        // new BookRowMapper(), // alternative to rowMapper
        rowMapper,
        isbn);
    return results.stream().findFirst();
  }

  // Instead of this, you can use an an anonymous inner class, OR a lambda expression https://www.youtube.com/watch?v=Nc9NmS5kEjU&t=1s
  public static class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Book.builder()
          .isbn(rs.getString("isbn"))
          .title(rs.getString("title"))
          .authorId(rs.getLong("author_id"))
          .build();
    }

  }

  @Override
  public List<Book> find() {
    return jdbcTemplate.query(
        "SELECT isbn, title, author_id from books",
        new BookRowMapper());
  }

  @Override
  public void update(String isbn, Book book) {
    jdbcTemplate.update(
        "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
        book.getIsbn(), book.getTitle(), book.getAuthorId(), isbn);
  }

  @Override
  public void delete(String isbn) {
    jdbcTemplate.update(
        "DELETE FROM books where isbn = ?",
        isbn);
  }
}
