package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.DishData;
import com.infoshare.myfitwebapp.model.DishDto;
import com.infoshare.myfitwebapp.model.ProductDto;
import com.infoshare.myfitwebapp.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dishes")
public class DishController {

    final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("")
    public ResponseEntity getAllDishes(Model model) {
        return new ResponseEntity<>(dishService.findAll(), HttpStatus.OK);
    }

//    @GetMapping("new")
//    public String addDish() {
//        return "dish-form";
//    }

//    @GetMapping("user/dish/new")
//    public String getProduct(Model model) {
//        model.addAttribute("dish", new DishData());
//        return "dish-new";
//    }

    @PostMapping("/new")
    public String addProduct(@Valid @ModelAttribute("dish") DishData dish, Errors errors) {
        if (errors.hasErrors()) {
            return "dish-new";
        }
        dishService.save(dish);
        dishService.saveDishDatabaseToFile();
        return "redirect:/";
    }

    @GetMapping(value="/new")
    public String addNewDish(Model model) {
        model.addAttribute("dish", new DishDto());
        return "dish-new";
    }

    @RequestMapping(value="/row")
    public String addRow(@ModelAttribute("dish") DishDto dishDto, final BindingResult bindingResult) {
        dishDto.getProducts().add(new ProductDto());
        return "dish-new";
    }

//    @RequestMapping(value="/user/dish/new", params={"addRow"})
//    public String addRow(final DishData dishData, final BindingResult bindingResult) {
//        dishData.getRows().add(new Row());
//        return "dish-new";
//    }

//    @RequestMapping(value="/user/dish/new", params={"removeRow"})
//    public String removeRow(
//            final DishData dishData, final BindingResult bindingResult,
//            final HttpServletRequest req) {
//        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
//        dishData.getRows().remove(rowId.intValue());
//        return "dish-new";
//    }
}
