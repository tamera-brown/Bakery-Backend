package com.tp.bakery.model;

public class Dessert {
    Integer dessertId;
    String name;
    String description;
    Double price;



    public Dessert(){}

    public Dessert(Dessert that){
        this.dessertId=that.dessertId;
        this.name= that.name;
        this.description = that.description;
        this.price=that.price;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
