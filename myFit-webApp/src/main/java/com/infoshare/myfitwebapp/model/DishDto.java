package com.infoshare.myfitwebapp.model;

import lombok.Data;

import java.util.List;

@Data
public class DishDto {

    private String name;
    private List<ProductDto> products;
}