package dev.study.service;

import java.util.List;

import dev.study.model.User;


public interface UserService {

	List<User> findAll();

	User save(User user);

	List<User> update(User todo);

	List<User> delete(Long userId);


    String login(String userId, String userPassWord);
}
