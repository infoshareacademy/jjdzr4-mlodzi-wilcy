package com.infoshare.myfitwebapp.model;

import java.util.ArrayList;
import java.util.List;

public class DishDto {

    private String name;
    private List<ProductRow> rows;

    public DishDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductRow> getRows() {
        return rows;
    }

    public void setRows(List<ProductRow> rows) {
        this.rows = rows;
    }

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