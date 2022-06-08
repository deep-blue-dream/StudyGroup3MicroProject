package dev.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dev.study.model.Post;
import dev.study.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository repository;
	
	@Override
	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public Post save(Post post) {
		return repository.save(post);
	}

	@Override
	public List<Post> delete(Long postId) {
		final Optional<Post> foundPost = repository.findById(postId);
		foundPost.ifPresent(post -> {
			repository.delete(post);
		});
		return repository.findAll();
	}
	
	@Override
	public List<Post> update(Post post) {

		final Optional<Post> foundPost = repository.findById(post.getPostId());
		foundPost.ifPresent(newpost -> {
			newpost.setPostTitle(post.getPostTitle());
			newpost.setPostDescription(post.getPostDescription());
			newpost.setPostDate(post.getPostDate());
			newpost.setIsrelease(post.isIsrelease());
			repository.save(newpost);// em.psersist()
		});
		return repository.findAll();// 전체데이터 반환(조회)
	}
}
