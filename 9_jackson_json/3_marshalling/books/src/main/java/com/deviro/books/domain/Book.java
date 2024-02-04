package com.deviro.books.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true) // this ignores extra json properties that are not included in this Book object
public class Book {

  private String isbn;

  private String title;

  private String author;

  @JsonProperty("year") // this will convert yearPublished in java object to year in json and vice versa via jackson
  private String yearPublished;
}
