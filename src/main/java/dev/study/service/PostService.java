package dev.study.service;

import java.util.List;

import dev.study.model.Post;

public interface PostService {

	List<Post> findAll();

	Post save(Post post);

	List<Post> update(Post post);

	List<Post> delete(Long postId);
}

