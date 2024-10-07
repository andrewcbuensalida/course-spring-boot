package com.devtiro.database.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // with this, able to do builder pattern, so instead of creating an instance with a constructor, you would do Author.builder().id(1L).build()
@Entity // This annotation marks the class as a JPA entity so hibernate can map it to a database table
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Long id;

    private String name;

    private Integer age;

}
