package dev.study.model;

import java.io.Serializable;

public class UserPostId implements Serializable{
	private Long userIndex;
	private Long postId;
	
	public UserPostId(){}
	public UserPostId(Long userIndex, Long postId ){
		this.userIndex = userIndex;
		this.postId = postId;
	}
	
}
