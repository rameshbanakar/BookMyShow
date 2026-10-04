package com.example.BookMyShow.Dto.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequestDto {
    private String newPassword;
    private String confirmPassword;
}
