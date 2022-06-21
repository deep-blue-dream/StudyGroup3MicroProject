package dev.study.repository;

import dev.study.model.Post;
import dev.study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.study.model.UserPost;


@Repository
public interface UserPostRepository extends JpaRepository<UserPost, Long>{

    UserPost findUserPostByUserAndPost(User user, Post post);

}
