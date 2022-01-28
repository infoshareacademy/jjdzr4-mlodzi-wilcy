package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getUser() {
        return "user";
    }
    }
