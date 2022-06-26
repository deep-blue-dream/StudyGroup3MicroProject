package dev.study.DTO;

import dev.study.model.Post;
import lombok.*;

import java.time.LocalDate;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {
    private Long postId;
    private String postTitle;
    private String postDescription;
    private LocalDate postDate;

    public PostDTO(Post post) {
        this.postId = post.getPostId();
        this.postTitle = post.getPostTitle();
        this.postDescription = post.getPostDescription();
        this.postDate = post.getPostDate();
    }
}
