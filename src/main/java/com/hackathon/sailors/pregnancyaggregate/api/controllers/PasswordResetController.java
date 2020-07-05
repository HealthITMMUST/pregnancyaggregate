package com.hackathon.sailors.pregnancyaggregate.api.controllers;

import com.hackathon.sailors.pregnancyaggregate.api.services.ResetPassService;
import com.hackathon.sailors.pregnancyaggregate.models.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class PasswordResetController {

    @Autowired
    private ResetPassService resetPassService;


    @GetMapping("/reset/{email}")
    public ApiResponse<String> resetPassword(@PathVariable String email){
        resetPassService.setResetMail(email);
        ApiResponse<String> response = new ApiResponse<>();
        response.setData(email);
        response.setResultCode(0);
        response.setData("please check your email for password reset instructions");
        return response;
    }
}
