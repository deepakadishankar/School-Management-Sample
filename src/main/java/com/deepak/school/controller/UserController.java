package com.deepak.school.controller;

import com.deepak.school.entity.User;
import com.deepak.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        userRepository.save(user);
        return "Success creating user";
    }
    @DeleteMapping
    public String deleteAllUsers(){
        userRepository.deleteAll();
        return "Deleted All Users Successfully";
    }
}
