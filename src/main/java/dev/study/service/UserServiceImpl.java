package dev.study.service;

import dev.study.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.study.repository.UserRepository;

import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		if(user == null || user.getUserMail() == null || user.getUserName() == null || user.getUserPassWord()==null){
			throw new RuntimeException("Invalid arguments");
		}
		final String email = user.getUserMail();
		System.out.println(email);
		if(userRepository.existsUserByUserMail(email)){
			log.warn("Email already exist >> {}", email);
			throw new RuntimeException("Email already exists");
		}
		return userRepository.save(user);
	}
}
