package com.infoshare.myfitwebapp.controller;

import com.infoshare.myfitwebapp.model.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @GetMapping("products/list")
    public List<ProductData> getProductDataList() {
        return null;
    }
}
