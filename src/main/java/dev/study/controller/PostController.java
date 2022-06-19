package dev.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.study.model.Post;
import dev.study.service.PostService;

@RestController
@RequestMapping("api/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public List<Post> findAll() {
		return postService.findAll();
	}
	
	// post 요청
	@PostMapping
	public Post save(@RequestBody Post post) {
		// @RequestBody - 클라이언트에서 보낸 값을 Todo의 필드와 맵핑해서 객체 형태로 바인딩
		return postService.save(post);
	}
	
	@PutMapping
	public List<Post> update(@RequestBody Post post) {
		return postService.update(post);
	}   
	
	@DeleteMapping("/{postId}")
	public List<Post> delete(@PathVariable("postId") Long postId){

		return postService.delete(postId);
	};

}
