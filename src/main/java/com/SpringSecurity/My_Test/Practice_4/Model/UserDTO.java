package com.SpringSecurity.My_Test.Practice_4.Model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {

    private String id;
    private String username;

    public static UserDTO from(User user) {
        return UserDTO.builder()  // Corrected the reference to the builder
                .id(String.valueOf(user.getId()))
                .username(user.getUserName())
                .build();
    }

}
