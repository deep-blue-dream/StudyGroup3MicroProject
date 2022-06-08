package dev.study.service;

import java.util.List;

import dev.study.model.Post;
import dev.study.model.User;
import dev.study.model.UserPost;

public interface UserService {

	List<User> findAll();

	User save(User user);

	List<User> update(User todo);

	List<User> delete(Long userId);
	

}
