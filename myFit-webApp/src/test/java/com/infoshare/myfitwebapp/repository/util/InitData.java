package com.infoshare.myfitwebapp.repository.util;

import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.repository.ProductRepository;
import com.infoshare.myfitwebapp.repository.UserDataRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitData {

    private final ProductRepository productRepository;

    public InitData(UserDataRepository userDataRepository, ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public void cleanUp() {
        productRepository.deleteAll();
    }


    public Product createProduct() {
        Product expected = new Product();
        expected.setName("3");
        expected.setKcalPer100g(30);
        expected.setFatPer100g(30);
        expected.setCarbohydratesPer100g(30);
        expected.setProteinPer100g(30);
        return expected;
    }

    @Transactional()
    public Product initProductData() {
        Product product = createProduct();
        return productRepository.save(product);
    }
}
