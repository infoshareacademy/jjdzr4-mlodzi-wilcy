package com.infoshare.myfitwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishController {

    @GetMapping("user/dishes")
    public String getAllDishes() {
        return "dishes";
    }

    @GetMapping("user/dishes/new")
    public String addDish() {
        return "dish-form";
    }
}
