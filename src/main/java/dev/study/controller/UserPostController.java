package dev.study.controller;

import dev.study.DTO.ResponseDTO;
import dev.study.DTO.UserPostDTO;
import dev.study.model.Post;
import dev.study.model.User;
import dev.study.service.PostService;
import dev.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.study.model.UserPost;
import dev.study.service.UserPostService;
@RestController
@RequestMapping("api/userpost")

public class UserPostController {

	@Autowired // 필드를 통한 인젝션(주입, DI)
	private UserPostService userPostService;

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserPostDTO userPostDTO) {

		try {
			User getuser = userService.findbyUserId(userPostDTO.getUserId());
			Post getpost = postService.findbyPostTitle(userPostDTO.getPostTitle());
			UserPost userPost = UserPost.builder()
					.user(getuser)
					.post(getpost)
					.build();
			userPostService.findUserPost(getuser, getpost);
			UserPost registerUserPost = userPostService.save(userPost);
			UserPostDTO responseUserPostDTO = UserPostDTO.builder().
					id(registerUserPost.getId())
					.userIndex(registerUserPost.getUser().getUserIndex())
					.userId(registerUserPost.getUser().getUserId())
					.postIndex(registerUserPost.getPost().getPostId())
					.postTitle(registerUserPost.getPost().getPostTitle())
					.build();
			return ResponseEntity.ok(responseUserPostDTO);
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity.badRequest().body(responseDTO);
		}


	}


}


