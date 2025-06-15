package com.example.MooMoo.controller;

import com.example.MooMoo.model.User;
import com.example.MooMoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        Optional<User> user = userService.getUserById(userId);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        try{
            List<User> users = userService.getAllUsers();
            if(!users.isEmpty()) return new ResponseEntity<>(users, HttpStatus.OK);
            return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody User user){
        try {
            User updatedUser = userService.updateUser(user, userId);
            return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("User cant be updated", HttpStatus.BAD_REQUEST);
        }
    }
 
}
