package dev.study.service;

import java.util.List;

import dev.study.DTO.UserDTO;
import dev.study.model.User;
import org.springframework.http.ResponseEntity;


public interface UserService {

	List<User> findAll();

	User save(User user);

	List<User> update(User todo);

	List<User> delete(Long userId);


  User login(UserDTO userDTO);

}
