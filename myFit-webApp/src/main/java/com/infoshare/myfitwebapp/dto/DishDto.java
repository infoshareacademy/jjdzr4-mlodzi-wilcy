package com.infoshare.myfitwebapp.dto;

import com.infoshare.myfitwebapp.model.ProductRow;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DishDto {

    private Long id;
    private String name;
    private int sumOfKcalPer100g;
    private double sumOfFatPer100g;
    private double sumOfCarbohydratesPer100g;
    private double sumOfProteinPer100g;

    private List<ProductDto> products;
    private List<ProductRow> productRows;

    public void addRow(ProductRow row) {
        if (productRows == null) {
            productRows = new ArrayList<>();
        }
        productRows.add(row);
    }

    public void removeRow(int rowId) {
        productRows.remove(rowId);
    }
}