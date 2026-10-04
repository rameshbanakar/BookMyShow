package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Dto.UserDto.*;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/forgot-password")
    public ResponseEntity<UserResponseDto> forgotPassword(@RequestBody UserLoginRequestDto userLoginRequestDto){
        UserResponseDto userResponseDto=new UserResponseDto();
        try{
            userService.generatePasswordResetToken(userLoginRequestDto);
            userResponseDto.setMessage("Reset password link sent to mail");
            return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
        } catch (Exception e) {
            userResponseDto.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userResponseDto);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<PasswordResponseDto> restPassword(@RequestParam("request_token") String token,
                                                            @RequestBody ResetPasswordRequestDto request){
        PasswordResponseDto passwordResponseDto=new PasswordResponseDto();
        try{
             userService.resetPassword(token,request);
             passwordResponseDto.setMessage("Password updated successfully");
             return ResponseEntity.ok().body(passwordResponseDto);
        }catch (Exception e){
            passwordResponseDto.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(passwordResponseDto);
        }
    }

}
