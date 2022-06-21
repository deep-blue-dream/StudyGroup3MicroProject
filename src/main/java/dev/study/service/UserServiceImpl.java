package dev.study.service;


import dev.study.DTO.UserDTO;
import dev.study.model.User;
import dev.study.repository.UserPostRepository;
import dev.study.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
@Slf4j
public class UserServiceImpl implements UserService{


	@Autowired
	private UserRepository repository;
	User user;

	@Autowired
	private UserPostRepository userPostRepository;

	@Override
	public List<User> findAll() {

		return repository.findAll();
	}

	@Override
	public User save(User user) {
		final String userEmail = user.getUserMail();
		final String userPassword = user.getUserPassWord();
		final String userId = user.getUserId();
		final String userName = user.getUserName();
		try{
			userEmailIsNull(userEmail);
			userPasswordIsNull(userPassword);
			userIdIsNull(userId);
			if(userName == null ) {
				log.error("userName is null");
				throw new RuntimeException("invalid userName");
			}
			if(repository.existsUserByUserId(userId)){
				log.warn("userId already exist >> {}", userEmail);
				throw new RuntimeException("userId already exists");
			}
			if(repository.existsUserByUserMail(userEmail)){
				log.warn("Email already exist >> {}", userEmail);
				throw new RuntimeException("Email already exists");
			}
		}catch (RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}


		return repository.save(user);
	}

	@Override
	public User login(UserDTO userDTO) {
		User user;
		final String userPassword = userDTO.getUserPassword();
		final String userId = userDTO.getUserId();
		try{
			userPasswordIsNull(userPassword);
			userIdIsNull(userId);
			if( repository.findUserByUserIdAndUserPassWord(userId, userPassword) == null){
				throw new RuntimeException("login failed");
			}
			user = repository.findUserByUserId(userId);
		}catch (RuntimeException e){
			throw new RuntimeException(e.getMessage());
		}
		return user;

	}

	@Override
	public User findbyUserId(String userId) {
		userIdIsNull(userId);
		if(repository.findUserByUserId(userId) == null){
			log.error("{} is null" ,userId);
			throw new RuntimeException("user is null");
		}
		return repository.findUserByUserId(userId);
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
	private void userEmailIsNull(String email){
		if(email == null || email.equals("")){
			log.error("email is null");
			throw  new RuntimeException("Invalid email");
		}
	}
	private void userIdIsNull(String userId){
		if(userId == null || userId.equals("")){
			log.error("userId is null");
			throw  new RuntimeException("Invalid userId");
		}
	}
	private void userPasswordIsNull(String password){
		if(password == null || password.equals("")){
			log.error("password is null");
			throw  new RuntimeException("Invalid password");
		}
	}

}



