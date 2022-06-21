package dev.study.DTO;

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
}
