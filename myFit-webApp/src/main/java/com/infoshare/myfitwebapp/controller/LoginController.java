package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.repository.UserDataRepository;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import com.infoshare.myfitwebapp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    RegisterService registerService;

    @GetMapping("")
    public String hello(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("register")
    public String register(){
        registerService.addUser();
        return "register";
    }
}
