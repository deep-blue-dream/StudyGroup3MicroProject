package dev.study.controller;

import java.util.List;

import dev.study.DTO.ResponseDTO;
import dev.study.DTO.UserDTO;
import dev.study.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;


import dev.study.model.User;
import dev.study.service.UserService;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
		try{
			User user = User.builder()
					.userName(userDTO.getUserName())
					.userMail(userDTO.getUserMail())
					.userId(userDTO.getUserId())
					.userPassWord(userDTO.getUserPassword())
					.build();
			System.out.println(userDTO.getUserPassword());
			User registerUser = userService.save(user);
			UserDTO responseUserDTO = UserDTO.builder()
					.userIndex(registerUser.getUserIndex())
					.userId(registerUser.getUserId())
					.userName(registerUser.getUserName())
					.userPassword(registerUser.getUserPassWord())
					.userMail(registerUser.getUserMail())
					.build();
			return ResponseEntity.ok(responseUserDTO);
		}catch (Exception e){
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return  ResponseEntity.badRequest().body(responseDTO);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<?> signin(@RequestBody UserDTO userDTO) {
		try{
			User user = userService.login(userDTO);
			UserDTO responseUserDTO = UserDTO.builder()
					.isSignedIn(true)
					.userIndex(user.getUserIndex())
					.userId(user.getUserId())
					.userMail(user.getUserMail())
					.userName(user.getUserName())
					.userPassword(user.getUserPassWord())
					.build();
			return ResponseEntity.ok(responseUserDTO);
		}catch (Exception e){
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return  ResponseEntity.badRequest().body(responseDTO);
		}
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
