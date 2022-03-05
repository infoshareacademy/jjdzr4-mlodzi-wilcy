package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.repository.ProductDataRepository;
import com.infoshare.myfitwebapp.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {

    private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

    final
    ProductService productService;

    final
    ProductDataRepository productDataRepository;

    public ProductController(ProductDataRepository productDataRepository, ProductService productService) {
        this.productDataRepository = productDataRepository;
        this.productService = productService;
    }

    @GetMapping("/name")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name){
        LOGGER.info("Received request for products with name: {}", name);
        return new ResponseEntity<>(productDataRepository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getProductsByName(){
        LOGGER.info("Received request for all products");
        return new ResponseEntity<>(productDataRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("new")
    public String getProduct(Model model) {
        LOGGER.info("Received request to add new product");
        model.addAttribute("product", new Product());
        return "products-new";
    }

    @PostMapping("new")
    public String addProduct(@Valid @ModelAttribute("product") Product product, Errors errors) {
        if (errors.hasErrors()) {
            LOGGER.error("Adding product failure. Form contains errors");
            return "products-new";
        }
        productService.save(product);
        LOGGER.info("New product saved");
        //TODO - merge save to file with save
        productService.saveProductDatabaseToFile();
        LOGGER.info("New product saved to file");
        return "redirect:/";
    }

}
