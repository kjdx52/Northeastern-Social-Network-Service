package com.Group11.NortheasternSocialNetwork.controller;
import com.Group11.NortheasternSocialNetwork.entity.UserLogin;
import com.Group11.NortheasternSocialNetwork.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping
    public ResponseEntity<String> loginUser(@RequestBody UserLogin userLoginRequest) {
        String username = userLoginRequest.getUsername();
        String timestamp = getCurrentTimestamp();

        // Save user login to MySQL
        userLoginService.saveUserLogin(username, timestamp);

        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

    private String getCurrentTimestamp() {
        // Implement your logic to get the timestamp
        return String.valueOf(System.currentTimeMillis());
    }
}

