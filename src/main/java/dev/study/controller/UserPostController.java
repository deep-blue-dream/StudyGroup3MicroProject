package dev.study.controller;

import dev.study.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
