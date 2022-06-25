package dev.study.service;

import org.springframework.beans.factory.annotation.Autowired;

import dev.study.model.Post;
import dev.study.model.User;
import dev.study.model.UserPost;
import dev.study.repository.PostRepository;
import dev.study.repository.UserPostRepository;
import dev.study.repository.UserRepository;

public class UserPostServiceImpl implements UserPostService{
	@Autowired
	private UserPostRepository userPostRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
//	@Override
//	public UserPost save(UserPost userPost) {
//		return repository.save(userPost);
//	}

	@Override
	public UserPost userPostSave(Long userIndex, Long postId) {
		User user = userRepository.findByUserIndex(userIndex);
		Post post = postRepository.findByPostId(postId);
		return userPostRepository.save(UserPost.builder()
				.user(user)
				.post(post)
				.build());
	}
}
