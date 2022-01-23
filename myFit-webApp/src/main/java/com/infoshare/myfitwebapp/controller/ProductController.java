package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.ProductData;
import com.infoshare.myfitwebapp.repository.ProductDataRepository;
import com.infoshare.myfitwebapp.service.ProductService;
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

    final
    ProductService productService;

    final
    ProductDataRepository productDataRepository;

    public ProductController(ProductDataRepository productDataRepository, ProductService productService) {
        this.productDataRepository = productDataRepository;
        this.productService = productService;
    }

    @GetMapping("/name")
    public ResponseEntity<List<ProductData>> getProductsByName(@RequestParam String name){
        return new ResponseEntity<>(productDataRepository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductData>> getProductsByName(){
        return new ResponseEntity<>(productDataRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("new")
    public String getProduct(Model model) {
        model.addAttribute("product", new ProductData());
        return "products-new";
    }

    @PostMapping("new")
    public String addProduct(@Valid @ModelAttribute("product") ProductData product, Errors errors) {
        if (errors.hasErrors()) {
            return "products-new";
        }
        productService.save(product);
        //TODO - merge save to file with save
        productService.saveProductDatabaseToFile();
        return "redirect:/";
    }

}
