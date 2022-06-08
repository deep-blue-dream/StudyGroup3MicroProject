package dev.study.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복 적용
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter @Getter
@ToString
@Entity
public class Post {
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	@Column(name="post_title",nullable=false)
	private String postTitle;
	@Column(name="post_description",nullable=false)
	private String postDescription;
	@Column(name="post_date",nullable=false)
	private LocalDate postDate;
	@Column(name="is_release",nullable=false)
	private boolean isrelease;

//	@OneToMany(fetch = FetchType.LAZY, targetEntity = User.class)
//	@JoinColumn(name="user_id")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
	private List<UserPost> user = new ArrayList<>();




	
	
}
