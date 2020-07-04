package com.hackathon.sailors.pregnancyaggregate.api.services;

import com.hackathon.sailors.pregnancyaggregate.models.dao.User;
import com.hackathon.sailors.pregnancyaggregate.web.dashboard.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
       return  userRepository.save(user);
    }
}
