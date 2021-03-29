package com.avla.test.controllers;


import com.avla.test.models.User;
import com.avla.test.models.UserProductLog;
import com.avla.test.repositories.UserProductLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "logs")


public class UserProductLogController {

    @Autowired
    private UserProductLogRepository userProductLogRepository;

    @GetMapping(value = "")
    public List<UserProductLog> getAllLogs(){
        return userProductLogRepository.findAll();
    }

    @PostMapping(value = "")
    public UserProductLog createLog(@RequestBody UserProductLog userProductLog,@RequestBody User user ){
        return userProductLogRepository.save(userProductLog);
    }
}
