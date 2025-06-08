package com.example.MooMoo.repository;

import com.example.MooMoo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, Long> {

}
