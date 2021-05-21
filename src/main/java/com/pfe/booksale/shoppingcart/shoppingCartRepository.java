package com.pfe.booksale.shoppingcart;


import com.pfe.booksale.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface shoppingCartRepository extends MongoRepository<ShoppingCart,String> {
    List<ShoppingCart> findShoppingCartByIde(String i);
    List<ShoppingCart> findByIde(String id);
}
