package dev.study.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Long userIndex;
    String userId;
    String userName;
    String userPassword;
    String userMail;

    boolean isSignedIn =false;

}
