package com.example.BookMyShow.Dto.UserDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignUpRequestDto {
    private String name;
    private String email;
    private String password;
}
