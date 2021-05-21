package com.pfe.booksale.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {

    List<Book> findByCategoryName(String category);
    List<Book> findByCategoryId(String id);
    List<Book> findByAuthorId(String id);
    Boolean existsByCategoryName(String category);
    List<Book> findAllBytitle(String title);
    List<Book> findBookByAuthorName(String name);
}
