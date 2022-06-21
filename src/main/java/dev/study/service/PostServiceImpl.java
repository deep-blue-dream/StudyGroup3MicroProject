package dev.study.service;

import dev.study.model.Post;
import dev.study.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
	@Override
	public Post create(Post post){
		postTitleIsNull(post.getPostTitle());
		if(repository.findPostByPostTitle(post.getPostTitle())!=null){
			log.warn("{} already exists",post.getPostTitle());
			throw new RuntimeException("post already exists");
		}
		return repository.save(post);
	}


	@Override
	public Post findbyPostTitle(String postTitle) {
		postTitleIsNull(postTitle);
		if(repository.findPostByPostTitle(postTitle) == null){
			log.error("{} is null", postTitle);
			throw new RuntimeException("Invalid postTitle");
		}
		return repository.findPostByPostTitle(postTitle);
	}
	private void postTitleIsNull(String postTitle){
		if(postTitle == null || postTitle.equals("")){
			log.error("postTitle is null");
			throw  new RuntimeException("Invalid postTitle");
		}
	}
}
