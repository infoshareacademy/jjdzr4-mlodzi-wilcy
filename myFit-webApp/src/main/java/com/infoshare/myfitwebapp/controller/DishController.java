package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.dto.DishDto;
import com.infoshare.myfitwebapp.dto.ProductDto;
import com.infoshare.myfitwebapp.model.ProductRow;
import com.infoshare.myfitwebapp.service.DishService;
import com.infoshare.myfitwebapp.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(DishController.class);

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
        LOGGER.info("Received request to add new dish");
        if (errors.hasErrors()) {
            LOGGER.error("Adding dish failure. Form contains errors");
            return "dish-new";
        }
        List<String> stringList = dishDto.getRows().stream().map(ProductRow::getProduct).collect(Collectors.toList());
        dishService.save(dishService.createDish(dishDto.getName(), stringList));
        LOGGER.info("New dish saved");
        dishService.saveDishDatabaseToFile();
        LOGGER.info("New dish saved to file");
        return "redirect:/dishes";
    }

    @GetMapping(value="/new")
    public String addNewDish(Model model) {
        LOGGER.info("Received request do add new dish");
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
