package dev.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.study.model.User;
import dev.study.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public List<User> update(User user) {
		final Optional<User> foundUser = repository.findById(user.getUserIndex());

		foundUser.ifPresent(newUser -> {// id값에 의한 엔티티가 존재하면(ifPresent)
			newUser.setUserId(user.getUserId());
			newUser.setUserName(user.getUserName());
			newUser.setUserMail(user.getUserMail());
			newUser.setUserPassWord(user.getUserPassWord());
			
			repository.save(newUser);
		});
			
	
		
		return repository.findAll();
	}

	@Override
	public List<User> delete(Long userId) {
		final Optional<User> foundTodo = repository.findById(userId);
				
		foundTodo.ifPresent(user->{
			repository.delete(user);
		
		});
		return repository.findAll();
	
	}
	
}
