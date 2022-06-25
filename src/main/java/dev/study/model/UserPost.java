package dev.study.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "UserPost")
@IdClass(UserPostId.class)

public class UserPost implements Serializable{
    

//	@Id
//    @Column(name="userpost_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    
	@Id
    @ManyToOne(fetch = FetchType.LAZY)//, targetEntity = User.class)
    @JoinColumn(name="user_index")
    private User user;

	@Id
    @ManyToOne(fetch = FetchType.LAZY)//, targetEntity = User.class)
    @JoinColumn(name="post_id")
    private Post post;
    
//    @Builder
//    public void userPost(User user, Post post) {
//    	this.user = user;
//    	this.post=post;
//    }

}