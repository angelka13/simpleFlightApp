package com.example.simpleapp.Repository;

import com.example.simpleapp.Model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}