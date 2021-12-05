package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.UserData;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public UserData getUser(){
        return userService.createUser();
    }

    @GetMapping("user/dishes")
    public String getUserDishes() {
        return "user-dishes";
    }
}
