package dev.study.DTO;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserPostDTO {
    private Long id;
    private String userId;
    private Long userIndex;
    private Long postIndex;
    private String postTitle;


}
