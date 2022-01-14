package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("user/product/new")
    public String getProduct(Model model) {
        model.addAttribute("product", new ProductData());
        return "product-new";
    }

}
