package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.DishData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("dishes")
public class DishController {

    @GetMapping("/")
    public DishData getAllDishes() {
        return null;
    }
}
