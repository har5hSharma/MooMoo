package com.example.MooMoo.service;

import com.example.MooMoo.model.User;
import com.example.MooMoo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void saveUser(User user){
        userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(String id){
        return userRepo.findById(id);
    }

    public User updateUser(User newUser, String userId){
        try{
            User oldUser = getUserById(userId).get();
            oldUser.setUser_pass(newUser.getUser_pass().isEmpty()?oldUser.getUser_pass():newUser.getUser_pass());
            oldUser.setLocation(newUser.getLocation().getCoordinates().isEmpty()?oldUser.getLocation():newUser.getLocation());
            oldUser.setAuth_token(newUser.getAuth_token().isEmpty()?oldUser.getAuth_token():newUser.getAuth_token());
            oldUser.setPhone_number(newUser.getPhone_number().toString().isEmpty()?oldUser.getPhone_number():newUser.getPhone_number());
            saveUser(oldUser);
            return oldUser;
        } catch (Exception e) {
            return null;
        }
    }

}
