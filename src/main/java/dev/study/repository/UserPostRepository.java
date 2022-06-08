package dev.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.study.model.UserPost;


@Repository
public interface UserPostRepository extends JpaRepository<UserPost, Long>{
	
}
