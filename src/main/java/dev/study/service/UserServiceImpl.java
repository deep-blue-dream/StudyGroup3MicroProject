package dev.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.study.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository repository;
}
