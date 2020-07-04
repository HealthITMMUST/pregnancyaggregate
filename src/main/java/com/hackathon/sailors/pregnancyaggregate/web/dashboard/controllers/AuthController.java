package com.hackathon.sailors.pregnancyaggregate.web.dashboard.controllers;

import com.hackathon.sailors.pregnancyaggregate.web.dashboard.services.AuthService;
import com.hackathon.sailors.pregnancyaggregate.models.LoginDetails;
import com.hackathon.sailors.pregnancyaggregate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthController {

    List<User> userList;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute LoginDetails loginDetails) {
        ModelAndView modelAndView = new ModelAndView();
        if(loginDetails.getUsername().equals("Admin") && loginDetails.getPassword().equals("admin")){

//            userList = new ArrayList<>(); //registerationService.findAllBussinessess();
//            modelAndView.addObject("bussinessList", userList);
            modelAndView.setViewName("dashboard");

        }else {
            modelAndView.setViewName("auth");
            modelAndView.addObject("wrongCredentials","Wrong username or password");
        }

        return modelAndView;

    }
}
