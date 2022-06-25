package dev.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.study.dao.UserPostDao;
import dev.study.model.Post;
import dev.study.model.User;
import dev.study.model.UserPost;
import dev.study.service.UserService;
@RequestMapping("api/users")
public class UserPostController {
	
//	@Autowired // 필드를 통한 인젝션(주입, DI)
//	private UserPostService userPostService;
	
	@Autowired
	private UserPostDao userpostdao;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("user/post/")
	
	// user id에 맞는 post리스트 불러오기
	public Object postList(@RequestParam final Long userIndex) {
		final User user = userService.findByUserIndex(userIndex); // 현재는 id지만 이름으로 조회 가능
		final List<UserPost> postUser = userpostdao.findAllByUserId(user.getUserIndex());
		
		
        final List<Post> PostList = new ArrayList<>();
        for (int i = 0; i < postUser.size(); i++)
        	PostList.add(postUser.get(i).getPost());
        
        return PostList;	
	}
	
//	@PostMapping()
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
