package com.tp.bakery.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Integer orderId;
    Integer dessertId;
    Integer quantity;
    String dessertName;
    String dessertDescription;
    Double dessertPrice;
    String dessertImage;

    public Order() {
    }

    ;

    public Order(Order that) {
        this.orderId = that.orderId;
        this.dessertId = that.dessertId;
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

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public String getDessertDescription() {
        return dessertDescription;
    }

    public void setDessertDescription(String dessertDescription) {
        this.dessertDescription = dessertDescription;
    }

    public Double getDessertPrice() {
        return dessertPrice;
    }

    public void setDessertPrice(Double dessertPrice) {
        this.dessertPrice = dessertPrice;
    }

    public String getDessertImage() {
        return dessertImage;
    }

    public void setDessertImage(String dessertImage) {
        this.dessertImage = dessertImage;
    }
}
