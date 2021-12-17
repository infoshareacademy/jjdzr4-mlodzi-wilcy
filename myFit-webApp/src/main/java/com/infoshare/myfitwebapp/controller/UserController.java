package com.infoshare.myfitwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("user")
    public String getUSer(){
        return "user";
    }

    @GetMapping("user/dishes")
    public String getUserDishes() {
        return "user-dishes";
    }
}
