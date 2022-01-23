package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.DishData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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
