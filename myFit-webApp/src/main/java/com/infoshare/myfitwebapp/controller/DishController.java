package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.DishData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DishController {

    @GetMapping("dishes")
    public DishData getAllDishes() {
        return null;
    }

    @GetMapping("user/dish/new")
    public String getProduct(Model model) {
        model.addAttribute("dish", new DishData());
        return "dish-new";
    }

    @PostMapping("user/dish/new")
    public String addProduct(@Valid @ModelAttribute("dish") DishData dish, Errors errors) {
        if (errors.hasErrors()) {
            return "dish-new";
        }

       /* TODO
            service.add(dish);*/

        return "redirect:/";
    }
}
