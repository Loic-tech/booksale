package com.pfe.booksale.wishlist;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishRepository extends MongoRepository<WishList,String> {
    List<WishList> findByIdu(String idu);
}
