package com.nanum.nanumserver.user.dto.response;

import com.nanum.nanumserver.user.domain.User;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class UserResponse {
    private final String username;

    public static UserResponse of(User user) {
        return new UserResponse(
                user.getUsername()
        );
    }

    public static Page<UserResponse> pageOf(Page<User> users) {
        return users.map(UserResponse::of);
    }
}
