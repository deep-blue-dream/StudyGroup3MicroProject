package dev.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.study.model.UserPost;
import dev.study.service.UserPostService;
@RequestMapping("api/users")
public class UserPostController {
	
	@Autowired // 필드를 통한 인젝션(주입, DI)
	private UserPostService userPostService;
	
	
//	@PostMapping
//	public UserPost save(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId){
//		userPostService.
//		
//		
//		System.out.println(userPost);
//		return userPostService.save(userPost);
//	}
	
////	@GetMapping(value = "/uploadPosting")
//	@GetMapping
//	public void uploadPosting(@RequestParam("id") Long index, @RequestParam("post") String post,
//			@RequestParam("category") Long categoryId,
//			@RequestParam("title") String title) {
//		
//		
//		
//		
//	}
}
