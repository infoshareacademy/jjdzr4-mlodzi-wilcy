package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.DishData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DishController {

    @GetMapping("dishes")
    public DishData getAllDishes() {
        return null;
    }
}
