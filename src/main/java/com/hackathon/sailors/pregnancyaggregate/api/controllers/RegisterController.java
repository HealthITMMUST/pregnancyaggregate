package com.hackathon.sailors.pregnancyaggregate.api.controllers;

import com.hackathon.sailors.pregnancyaggregate.api.services.RegisterService;
import com.hackathon.sailors.pregnancyaggregate.models.User;
import com.hackathon.sailors.pregnancyaggregate.models.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ApiResponse<User> registerUser(@RequestBody User user) {
        User createdUser = registerService.createUser(user);
        ApiResponse<User> response = new ApiResponse<>();
        response.setData(createdUser);

        if(createdUser != null){
            response.setResultCode(0);
            response.setResultDescription("userCreated created successfully");
        }else{
            response.setResultCode(1);
            response.setResultDescription("There was an error while creating User");
        }

        return response;
    }


}
