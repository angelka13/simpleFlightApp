package com.example.simpleapp.Repository;

import com.example.simpleapp.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);


}