package com.hackathon.sailors.pregnancyaggregate.api.controllers;

import com.hackathon.sailors.pregnancyaggregate.api.services.LoginService;
import com.hackathon.sailors.pregnancyaggregate.models.LoginDetails;
import com.hackathon.sailors.pregnancyaggregate.models.User;
import com.hackathon.sailors.pregnancyaggregate.models.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ApiResponse<User> login(@RequestBody LoginDetails credentials){
        User incomingUser = loginService.login(credentials.getUsername(), credentials.getPassword());
        ApiResponse<User> response = new ApiResponse<>();
        response.setData(incomingUser);
        if(incomingUser != null){
            response.setResultCode(0);
            response.setResultDescription("user logged in successfully");
        }else {
           response.setResultCode(1);
           response.setResultDescription("error loging in check credentials");
        }

        return  response;
    }

}
