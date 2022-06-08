package dev.study.controller;

import dev.study.model.User;
import dev.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @PostMapping("/signup")
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    
}
