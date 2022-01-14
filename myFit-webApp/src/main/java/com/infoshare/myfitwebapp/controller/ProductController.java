package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.ProductData;
import com.infoshare.myfitwebapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("user/product/new")
    public String getProduct(Model model) {
        model.addAttribute("product", new ProductData());
        return "product-new";
    }

    @PostMapping("user/product/new")
    public String sendTask(@ModelAttribute("task") ProductData productData) {
        return "product-succes";

    }
}
