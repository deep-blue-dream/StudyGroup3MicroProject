package dev.study.service;

import dev.study.model.Post;
import dev.study.model.User;
import dev.study.model.UserPost;
import dev.study.repository.UserPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserPostServiceImpl implements UserPostService{
	@Autowired
	private UserPostRepository repository;


	@Override
	public UserPost save(UserPost userPost) {
		return repository.save(userPost);
	}

	@Override
	public void findUserPost(User user, Post post) {
		if (repository.findUserPostByUserAndPost(user, post) !=null) {
			log.warn("{} , {} already exits",user.getUserId(), post.getPostTitle());
			throw new RuntimeException("userId and postId already exits ");
		}
	}


}
