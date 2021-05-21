package com.pfe.booksale.category;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
    Optional<Category> findByname(String name);

    void deleteByname(String name);

    List<Category> findAllByname();
}
