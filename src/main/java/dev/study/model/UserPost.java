package dev.study.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserPost {

    @Id
    @Column(name="userpost_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)//, targetEntity = User.class)
    @JoinColumn(name="user_index")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)//, targetEntity = User.class)
    @JoinColumn(name="post_id")
    private Post post;
}


