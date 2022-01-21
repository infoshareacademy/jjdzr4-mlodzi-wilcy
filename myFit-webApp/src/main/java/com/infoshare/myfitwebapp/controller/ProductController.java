package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {

    @GetMapping("user/product/new")
    public String getProduct(Model model) {
        model.addAttribute("product", new ProductData());
        return "product-new";
    }

    @PostMapping("user/product/new")
    public String addProduct(@Valid @ModelAttribute("product") ProductData product, Errors errors) {
        if (errors.hasErrors()) {
            return "product-new";
        }

       /* TODO
            service.add(product);*/

        return "redirect:/";
    }

}