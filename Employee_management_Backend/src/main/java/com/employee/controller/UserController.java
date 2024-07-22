package com.employee.controller;

import com.employee.dto.LoginResponse;
import com.employee.dto.UserLoginRequest;
import com.employee.entity.User;
import com.employee.repo.UserRepo;
import com.employee.servies.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserServise servise;
    
    @Autowired
    private UserRepo userRepository;
    
    
//register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        try {
            User savedUser = servise.insertUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    //login
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserLoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) { // Compare hashed passwords in production
            return ResponseEntity.ok(new LoginResponse(true));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false));
        }
    }

   
    
    
    
}
