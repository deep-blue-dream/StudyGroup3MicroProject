package dev.study.service;

import dev.study.model.UserPost;
import dev.study.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserPostServiceImpl implements UserPostService{
	@Autowired
	private UserPostRepository repository;

	@Override
	public UserPost save(UserPost userPost) {
		return repository.save(userPost);
	}

	
}
