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
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
public class User {

	@Id
	@Column(name="user_index")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userIndex;
	
	@Column(name="user_id")
	private String userId;
	@Column(name="user_name",nullable=false)
	private String userName;
	@Column(name="user_pw",nullable=false)
	private String userPassWord;
	@Column(name="user_mail",nullable=false)
	private String userMail;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<UserPost> userpost = new ArrayList<>();

	@Override
	public String toString() {
		String result = "User{" +
				"userIndex=" + userIndex +
				", userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", userPassWord='" + userPassWord + '\'' +
				", userMail='" + userMail + '\'' +
				'}';

		return result;

	}
}