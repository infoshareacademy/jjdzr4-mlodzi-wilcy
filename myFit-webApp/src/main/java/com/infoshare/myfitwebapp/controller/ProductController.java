package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.repository.ProductRepository;
import com.infoshare.myfitwebapp.service.ProductService;
import org.springframework.data.repository.query.Param;
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

    private final ProductService productService;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping()
    public String getProductsList(Model model){
        model.addAttribute("productsList", productService.findAllProducts());
        new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
        return "products";
    }

    @GetMapping("search")
    public String getResultOfSearch(@Param("name") String name, Model model) {
        model.addAttribute("productsList", productService.findProductsByName(name));
        model.addAttribute("name", name);
        model.addAttribute("description", "Search for '" + name + "' in products names");
        model.addAttribute("tableDesc", "Table of products that have '"+ name +"' in their name");
        return "products-search-result";
    }

    @GetMapping("name")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name){
        return new ResponseEntity<>(productRepository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("new")
    public String getProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products-new";
    }

    @PostMapping("new")
    public String addProduct(@Valid @ModelAttribute("product") Product product, Errors errors) {
        if (errors.hasErrors()) {
            return "products-new";
        }
        productService.save(product);
        //TODO - merge save to file with save
        productService.saveProductDatabaseToFile();
        return "redirect:/";
    }

}
