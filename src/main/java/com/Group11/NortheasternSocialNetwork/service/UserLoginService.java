package com.Group11.NortheasternSocialNetwork.service;

import com.Group11.NortheasternSocialNetwork.entity.UserLogin;
import com.Group11.NortheasternSocialNetwork.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    public void saveUserLogin(String username, String timestamp) {
        UserLogin userLogin = new UserLogin(username, timestamp);
        userLoginRepository.save(userLogin);
    }
}
