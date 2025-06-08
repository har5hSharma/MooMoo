package com.example.MooMoo.service;

import com.example.MooMoo.model.User;
import com.example.MooMoo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void saveClient(User user){
        userRepo.save(user);
    }

    public List<User> getAllClients(){
        return userRepo.findAll();
    }

}
