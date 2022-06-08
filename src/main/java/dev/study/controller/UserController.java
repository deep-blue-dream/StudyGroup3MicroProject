package dev.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import dev.study.model.User;
import dev.study.service.UserService;

import org.springframework.web.bind.annotation.*;


@RestController


@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@PostMapping("/signup")
	public User save(@RequestBody User user) {
		return userService.save(user);
		
	}
	@PostMapping("/login")
	public String login(@RequestBody User user){
		return userService.login(user.getUserId(),user.getUserPassWord());

	}
		
	@PutMapping
	public List<User> update(@RequestBody User user){
		return userService.update(user);
	}

	@DeleteMapping("/{userId}")
	public List<User> delete(@PathVariable("userId") Long userId){

		return userService.delete(userId);
	}


}
