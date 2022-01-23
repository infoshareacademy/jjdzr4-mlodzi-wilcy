package com.infoshare.myfitwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dishes")
public class DishController {

    @GetMapping("")
    public String getAllDishes() {
        return "dishes";
    }

    @GetMapping("new")
    public String addDish() {
        return "dish-form";
    }
}
