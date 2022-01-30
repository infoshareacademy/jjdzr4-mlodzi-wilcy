package com.infoshare.myfitwebapp.model;

public class ProductRow {

    // Docelowo powinno działać z ProductDto productDto;
    private String product;
    private int amount;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
