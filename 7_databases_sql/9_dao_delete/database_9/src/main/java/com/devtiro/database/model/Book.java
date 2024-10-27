package com.devtiro.database.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@Scope("prototype") // 1 bean per request, not singleton
public class Book {

    private String isbn;
    private String title;
    private Long authorId;

}
