package com.infoshare.myfitwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DietController {

    @GetMapping("user/diet")
    public String getAllDishes() {
        return "diet";
    }

}
