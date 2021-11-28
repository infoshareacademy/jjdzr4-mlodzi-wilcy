package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.ProductData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("products")
@Component
public class ProductController {

    @GetMapping("/productsList")
    public List<ProductData> getProductDataList() {
        return null;
    }
}
