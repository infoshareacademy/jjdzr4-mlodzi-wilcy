package com.infoshare.myfitwebapp.mapper;

import com.infoshare.myfitwebapp.entity.ProductEntity;
import com.infoshare.myfitwebapp.model.ProductData;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ProductData toDto(ProductEntity product) {
        ProductData dto = new ProductData();
        dto.setName(product.getName());
        dto.setCarbohydratesPer100g(product.getCarbohydratesPer100g());
        dto.setKcalPer100g(product.getKcalPer100g());
        dto.setFatPer100g(product.getFatPer100g());
        dto.setProteinPer100g(product.getProteinPer100g());

        return dto;
    }

    public ProductEntity toEntity(ProductData product) {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setCarbohydratesPer100g(product.getCarbohydratesPer100g());
        entity.setKcalPer100g(product.getKcalPer100g());
        entity.setFatPer100g(product.getFatPer100g());
        entity.setProteinPer100g(product.getProteinPer100g());

        return entity;
    }
}
