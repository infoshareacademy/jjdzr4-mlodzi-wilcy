package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.dto.DishDto;
import com.infoshare.myfitwebapp.dto.ProductDto;
import com.infoshare.myfitwebapp.model.ProductRow;
import com.infoshare.myfitwebapp.service.DishService;
import com.infoshare.myfitwebapp.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("dishes")
public class DishController {

    private static final Logger LOGGER = LogManager.getLogger(DishController.class);

    private final DishService dishService;
    private final ProductService productService;

    public DishController(DishService dishService, ProductService productService) {
        this.dishService = dishService;
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllDishes(Model model) {
        model.addAttribute("dishList", dishService.findAll());
        return "dishes";
    }

    @GetMapping("search")
    public String getResultOfSearch(@Param("name") String name, Model model) {
        model.addAttribute("dishList", dishService.findByName(name));
        model.addAttribute("name", name);
        model.addAttribute("description", "Search for '" + name + "' in dishes names");
        model.addAttribute("tableDesc", "Table of dishes that have '" + name + "' in their name");
        return "dishes-search-result";
    }

    @PostMapping("new")
    public String addProduct(@Valid final DishDto dishDto, Errors errors) {
        LOGGER.info("Received request to add new dish");
        if (errors.hasErrors()) {
            LOGGER.error("Adding dish failure. Form contains errors");
            return "dish-new";
        }
        List<String> stringList = dishDto.getProductRows().stream().map(ProductRow::getProduct).collect(Collectors.toList());
        dishService.save(dishService.create(dishDto.getName(), stringList));
        LOGGER.info("New dish saved");
        dishService.saveDatabaseToFile();
        LOGGER.info("New dish saved to file");
        return "redirect:/dishes";
    }

    @GetMapping(value = "new")
    public String addNewDish(Model model) {
        LOGGER.info("Received request do add new dish");
        model.addAttribute("dishDto", new DishDto());
        return "dish-new";
    }

    @RequestMapping(value = "new", params = {"addRow"})
    public String addRow(final DishDto dishDto, final BindingResult bindingResult) {
        dishDto.addRow(new ProductRow());
        return "dish-new";
    }

    @RequestMapping(value = "new", params = {"removeRow"})
    public String removeRow(final DishDto dishDto, final BindingResult bindingResult, final HttpServletRequest req) {
        final int rowId = Integer.parseInt(req.getParameter("removeRow"));
        dishDto.removeRow(rowId);
        return "dish-new";
    }

    @GetMapping("edit/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model) {
        DishDto dishDtoById = dishService.findById(id);
        model.addAttribute("dish", dishDtoById);
        return "dish-edit-form";
    }

    @PostMapping(value = "update")
    public String editDish(@Valid @ModelAttribute("dish") DishDto dish, Model model) {
        DishDto update = dishService.update(dish);
        if (update == null) {
            return "error/500";
        }
        model.addAttribute("dish", update);
        return "redirect:/dishes";
    }

    @ModelAttribute("allProducts")
    public List<ProductDto> populateProducts() {
        return productService.findAllProducts();
    }
}
