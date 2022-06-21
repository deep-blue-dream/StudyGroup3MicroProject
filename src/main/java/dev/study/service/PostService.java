package dev.study.service;

import dev.study.model.Post;

import java.util.List;

public interface PostService {

	List<Post> findAll();

	Post save(Post post);

	List<Post> update(Post post);

	List<Post> delete(Long postId);

    Post create(Post post);

	Post findbyPostTitle(String postTitle);
}

