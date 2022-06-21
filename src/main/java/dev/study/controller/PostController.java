package dev.study.controller;

import dev.study.DTO.PostDTO;
import dev.study.DTO.ResponseDTO;
import dev.study.model.Post;
import dev.study.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public List<Post> findAll() {
		return postService.findAll();
	}
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody PostDTO postDTO){
		try{
			Post post = Post.builder()
					.postDate(postDTO.getPostDate())
					.postDescription(postDTO.getPostDescription())
					.postTitle(postDTO.getPostTitle())
					.build();
			Post registerPost = postService.create(post);
			PostDTO responsePostDTO = PostDTO.builder()
					.postDate(registerPost.getPostDate())
					.postTitle(registerPost.getPostTitle())
					.postId(registerPost.getPostId())
					.postDescription(registerPost.getPostDescription())
					.build();
			return ResponseEntity.ok(responsePostDTO);


		}catch (Exception e){
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return  ResponseEntity.badRequest().body(responseDTO);
		}
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
