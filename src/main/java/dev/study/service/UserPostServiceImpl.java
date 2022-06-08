package dev.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.study.model.User;
import dev.study.model.UserPost;
import dev.study.repository.UserPostRepository;

public class UserPostServiceImpl implements UserPostService{
	@Autowired
	private UserPostRepository repository;

	@Override
	public UserPost save(UserPost userPost) {
		return repository.save(userPost);
	}

	
}
