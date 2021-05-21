package com.pfe.booksale.checkout;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckoutRepository extends MongoRepository<Checkout,String> {
    List<Checkout> findByEmail(String email);
}
