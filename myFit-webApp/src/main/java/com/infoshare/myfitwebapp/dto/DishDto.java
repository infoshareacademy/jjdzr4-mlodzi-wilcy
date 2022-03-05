package com.infoshare.myfitwebapp.dto;

import com.infoshare.myfitwebapp.model.ProductRow;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DishDto {

    private String name;
    private List<ProductDto> products;
    private List<ProductRow> rows;

    public void addRow(ProductRow row) {
        if (rows == null) {
            rows = new ArrayList<>();
        }
        rows.add(row);
    }

    public void removeRow(int rowId) {
        rows.remove(rowId);
    }
}