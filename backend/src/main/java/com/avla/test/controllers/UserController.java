package com.avla.test.controllers;


import com.avla.test.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.avla.test.repositories.UserRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "users")
public class UserController {

        @Autowired
        private UserRepository userRepository;

        @GetMapping(value = "")
        public List<User> getAllUsers(){
            return userRepository.findAll();
        }

        @PostMapping(value = "")
        public User createUser(@RequestBody User user){
            return userRepository.save(user);
        }

}
