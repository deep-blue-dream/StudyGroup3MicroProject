package dev.study.service;

import dev.study.model.Post;
import dev.study.model.User;
import dev.study.model.UserPost;

public interface UserPostService {

	UserPost save(UserPost userPost);


	void findUserPost(User user, Post post);
}
