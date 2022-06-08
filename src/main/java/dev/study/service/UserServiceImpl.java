package dev.study.service;


import java.util.List;
import java.util.Optional;


import dev.study.model.User;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.study.repository.UserRepository;




@Service
@Slf4j
public class UserServiceImpl implements UserService{


	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {

		return repository.findAll();
	}

	@Override
	public User save(User user) {
		if(user == null || user.getUserMail() == null || user.getUserName() == null || user.getUserPassWord()==null){
			throw new RuntimeException("Invalid arguments");
		}
		final String email = user.getUserMail();
		System.out.println(email);
		if(repository.existsUserByUserMail(email)){
			log.warn("Email already exist >> {}", email);
			throw new RuntimeException("Email already exists");
		}
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

	@Override
	public String login(String userId, String userPassWord) {
		User user = repository.findUserByUserIdAndUserPassWord(userId, userPassWord);
		if(user !=null){
			return user.toString();
		}else{
			log.error("login failed");
			return "아이디나 비밀번호가 틀렸습니다";
		}
	}

}



