package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("user/dishes")
    public String getUserDishes() {
        return "user-dishes";
    }
}
