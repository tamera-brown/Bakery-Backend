package com.tp.bakery.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    String name;
    String email;
    List<Dessert> BagItems;
    Double totalPrice;

    public Order(){};

    public Order(Order that){
        this.name= that.name;
        this.email= that.email;
        this.BagItems=new ArrayList<>();
        for(Dessert toCopy : that.BagItems){
            this.BagItems.add(toCopy);
        }
        this.totalPrice=that.totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Dessert> getBagItems() {
        return BagItems;
    }

    public void setBagItems(List<Dessert> bagItems) {
        BagItems = bagItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
