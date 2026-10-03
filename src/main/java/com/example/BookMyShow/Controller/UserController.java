package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dto.UserDto.UserLoginRequestDto;
import com.example.BookMyShow.Dto.UserDto.UserResponseDto;
import com.example.BookMyShow.Dto.UserDto.UserSignUpRequestDto;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserSignUpRequestDto userSignUpRequestDto){

        UserResponseDto userResponseDto=new UserResponseDto();
        try{
            UserService.SignupResult result=userService.signup(userSignUpRequestDto);
            userResponseDto.setUserId(result.user().getId());
            userResponseDto.setEmail(result.user().getEmail());
            userResponseDto.setToken(result.token());
            userResponseDto.setMessage("User signup success");

            return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);

        }catch(Exception e){
            userResponseDto.setMessage(e.getMessage());
           return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(userResponseDto);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        UserResponseDto userResponseDto=new UserResponseDto();
        try{
            UserService.SignupResult result=userService.login(userLoginRequestDto);
            userResponseDto.setUserId(result.user().getId());
            userResponseDto.setEmail(result.user().getEmail());
            userResponseDto.setToken(result.token());
            userResponseDto.setMessage("User login success");
            return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);

        }catch(Exception e){
            userResponseDto.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(userResponseDto);
        }
    }



}
