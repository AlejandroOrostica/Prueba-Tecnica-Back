package com.avla.test.controllers;


import com.avla.test.models.User;
import com.avla.test.models.UserProductLog;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.avla.test.repositories.UserRepository;

import java.util.List;
import java.util.Map;

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

        @GetMapping(value = "{userId}/logs")
        public List<UserProductLog> getAllLogs(@PathVariable(value = "userId") Long userId){
            User user = userRepository.findUserById(userId);
            return user.getLogs();
        }

        @PostMapping(value = "login")
        public ResponseEntity<User>  createUser(@RequestBody Map<String,Object> json){
            String email = json.get("email").toString();
            String password = json.get("password").toString();
            User user = userRepository.findUserByEmailAndPassword(email, password);
            if (user != null){
                return new ResponseEntity<>(user, HttpStatus.OK) ;
            }
            else{
                return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST) ;
            }

        }

}
