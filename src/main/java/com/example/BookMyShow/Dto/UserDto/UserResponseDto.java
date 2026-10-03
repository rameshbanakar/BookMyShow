package com.example.BookMyShow.Dto.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private int userId;
    private String email;
    private String token;
    private String message;
}
