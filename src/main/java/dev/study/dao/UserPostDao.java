package dev.study.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.study.model.UserPost;
import dev.study.model.UserPostId;
public interface UserPostDao extends JpaRepository<UserPost, UserPostId>{
	List<UserPost> findAllByUserId(Long userId);
	
}
