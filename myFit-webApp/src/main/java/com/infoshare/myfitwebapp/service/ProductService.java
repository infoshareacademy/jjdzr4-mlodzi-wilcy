package com.infoshare.myfitwebapp.service;

import com.infoshare.ProductInfo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    final AddNewProductService addNewProductService;

    public ProductService(AddNewProductService addNewProductService) {
        this.addNewProductService = addNewProductService;
    }

    public ProductInfo createProduct() {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setName("Woda");
        productInfo.setKcalPer100g(1);
        productInfo.setFatPer100g(0);
        productInfo.setCarbohydratesPer100g(0);
        productInfo.setProteinPer100g(0);
        return productInfo;
    }


}
