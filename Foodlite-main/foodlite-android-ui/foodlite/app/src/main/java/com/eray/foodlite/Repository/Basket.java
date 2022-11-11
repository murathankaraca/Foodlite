package com.eray.foodlite.Repository;

import com.eray.foodlite.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    public static Basket Instance;

    public List<Product> productList;

    public Basket() {
        if(Instance == null) {
            Instance = this;
            productList = new ArrayList<Product>();
        }
    }

    public double getTotalPrice() {
        double price = 0.0;
        for(Product p: productList) {
            price += p.getPrice();
        }
        return price;
    }
}
