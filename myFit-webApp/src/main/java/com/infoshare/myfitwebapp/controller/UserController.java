package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public UserData getUser(){
        return userService.createUser();
    }
}
