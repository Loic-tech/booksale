package com.pfe.booksale.Profile;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile,String>  {
    Optional<Profile> findByIduser(String id);
}
