package com.hackathon.sailors.pregnancyaggregate.api.services;

import com.hackathon.sailors.pregnancyaggregate.api.repo.UserRepository;
import com.hackathon.sailors.pregnancyaggregate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
      return   userRepository.findAll();
    }
}
