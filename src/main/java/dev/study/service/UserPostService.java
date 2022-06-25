package dev.study.service;

import dev.study.model.UserPost;

public interface UserPostService {

	UserPost userPostSave(Long userIndex, Long postId);

}
