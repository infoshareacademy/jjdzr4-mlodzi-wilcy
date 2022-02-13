package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.DishDto;
import com.infoshare.myfitwebapp.model.ProductDto;
import com.infoshare.myfitwebapp.model.ProductRow;
import com.infoshare.myfitwebapp.service.DishService;
import com.infoshare.myfitwebapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("dishes")
public class DishController {

    private final DishService dishService;
    private final ProductService productService;

    public DishController(DishService dishService, ProductService productService) {
        this.dishService = dishService;
        this.productService = productService;
    }

    // Ten endpoint do zmiany -> z DishService wyciągnąć List<DishDto>
    @GetMapping("")
    public ResponseEntity getAllDishes(Model model) {
        return new ResponseEntity<>(dishService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public String addProduct(@Valid final DishDto dishDto, Errors errors) {
        if (errors.hasErrors()) {
            return "dish-new";
        }
        List<String> stringList = dishDto.getRows().stream().map(ProductRow::getProduct).collect(Collectors.toList());
        dishService.save(dishService.createDish(dishDto.getName(), stringList));
        dishService.saveDishDatabaseToFile();
        return "redirect:/dishes";
    }

    @GetMapping(value="/new")
    public String addNewDish(Model model) {
        model.addAttribute("dishDto", new DishDto());
        return "dish-new";
    }

    @RequestMapping(value="/new", params={"addRow"})
    public String addRow(final DishDto dishDto, final BindingResult bindingResult) {
        dishDto.addRow(new ProductRow());
        return "dish-new";
    }

    @RequestMapping(value="/new", params={"removeRow"})
    public String removeRow(final DishDto dishDto, final BindingResult bindingResult, final HttpServletRequest req) {
        final int rowId = Integer.parseInt(req.getParameter("removeRow"));
        dishDto.removeRow(rowId);
        return "dish-new";
    }

    @ModelAttribute("allProducts")
    public List<ProductDto> populateProducts() {
        return productService.getProductDtos();
    }
}
