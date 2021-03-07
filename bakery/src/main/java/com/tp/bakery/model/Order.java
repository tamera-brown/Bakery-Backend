package com.tp.bakery.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Integer orderId;
    Integer dessertId;
    List<Dessert> bagItems;
    Integer quantity;


    public Order() {
    }


    public Order(Order that) {
        this.orderId = that.orderId;
        this.dessertId = that.dessertId;
        this.bagItems=new ArrayList<>();
        for(Dessert toCopy : that.bagItems){
            this.bagItems.add(toCopy);
        }
        that.quantity = that.quantity;

    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Dessert> getBagItems() {
        return bagItems;
    }

    public void setBagItems(List<Dessert> bagItems) {
        this.bagItems = bagItems;
    }
}
