package com.infoshare.myfitwebapp.controller;

import com.infoshare.ProductInfo;
import com.infoshare.myfitwebapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("user/product")
    public ProductInfo getProduct() {
        return productService.createProduct();
    }

    @GetMapping("user/product/new")
    public String getNewProduct() {
        return "product-new";
    }
}
