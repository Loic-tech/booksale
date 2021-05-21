package com.pfe.booksale.auteur;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuteurRepository extends MongoRepository<Auteur,String> {

    Optional<Auteur> findByname(String name);

    void deleteByname(String name);
}
