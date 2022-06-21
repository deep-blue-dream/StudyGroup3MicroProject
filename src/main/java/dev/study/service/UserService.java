package dev.study.service;

import dev.study.DTO.UserDTO;
import dev.study.model.User;

import java.util.List;


public interface UserService {

	List<User> findAll();

	User save(User user);

	List<User> update(User todo);

	List<User> delete(Long userId);


    User login(UserDTO userDTO);

	User findbyUserId(String userId);
}
