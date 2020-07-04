package com.hackathon.sailors.pregnancyaggregate.api.services;

import com.hackathon.sailors.pregnancyaggregate.api.repo.UserRepository;
import com.hackathon.sailors.pregnancyaggregate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User login(String name, String password) {
        return userRepository.getUserByNameAndPassword(name, password);
    }
}
