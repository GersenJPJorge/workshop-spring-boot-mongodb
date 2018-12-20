package com.gersen.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gersen.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
