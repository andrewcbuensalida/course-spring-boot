package com.devtiro.database.services;

import com.devtiro.database.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

// AuthorService is an interface because just in case we want to implement multiple versions of it, like 1 for postgresql and another for mysql
public interface AuthorService {
    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findOne(Long id);

    boolean isExists(Long id);

    AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    void delete(Long id);
}
