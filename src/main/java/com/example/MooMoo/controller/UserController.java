package com.example.MooMoo.controller;

import com.example.MooMoo.model.User;
import com.example.MooMoo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody User user){
        try{
            userService.saveClient(user);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllClients(){
        try{
            List<User> users = userService.getAllClients();
            if(!users.isEmpty()) return new ResponseEntity<>(users, HttpStatus.OK);
            return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
 
}
