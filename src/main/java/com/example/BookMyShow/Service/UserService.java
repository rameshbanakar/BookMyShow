package com.example.BookMyShow.Service;

import com.example.BookMyShow.CustomeExceptions.InvlidInput;
import com.example.BookMyShow.CustomeExceptions.UserAlreadyFound;
import com.example.BookMyShow.CustomeExceptions.UserNotFound;
import com.example.BookMyShow.Dto.UserDto.UserLoginRequestDto;
import com.example.BookMyShow.Dto.UserDto.UserSignUpRequestDto;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.UserRepo;
import com.example.BookMyShow.Service.NotificationService.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private NotificationService notificationService;

    public record SignupResult(User user, String token) {}

    public SignupResult signup(UserSignUpRequestDto userSignUpRequestDto){
        String email=userSignUpRequestDto.getEmail();
        String name=userSignUpRequestDto.getName();
        String password=userSignUpRequestDto.getPassword();
        if(name.equals(null) || email.equals(null) || password.equals(null)){
            throw new InvlidInput("Invalid input");
        }
        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()){
            throw new UserAlreadyFound("User already exist");
        }
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        String hashPassword=passwordEncoder.encode(password);
        user.setPassword(hashPassword);

        String token=jwtService.generateToken(email);
        SignupResult results= new SignupResult(user,token);
        userRepo.save(user);
        return results;

    }

    public SignupResult login(UserLoginRequestDto userLoginRequestDto){
        String email=userLoginRequestDto.getEmail();
        String password=userLoginRequestDto.getPassword();

        Optional<User> userOptional=userRepo.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new UserNotFound("User not found with the email");
        }
        User user=userOptional.get();

        boolean isPasswordMatch= passwordEncoder.matches(password,user.getPassword());
        if(!isPasswordMatch){
            throw new InvlidInput("Invalid credentials");
        }
        String token=jwtService.generateToken(user.getEmail());

        return new SignupResult(user,token);
    }

    public void generatePasswordResetToken(String email){
        if(email.equals(null)){
            throw new InvlidInput("Enter the email");
        }


    }
}
