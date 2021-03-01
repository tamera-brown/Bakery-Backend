package com.tp.bakery.persistence;

import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;

import java.util.List;

public interface DessertDAO {
    List<Dessert> getAllDesserts();

    Dessert addDessert(Dessert dessert) throws NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException,NullDessertPriceException;

    Dessert getDessertById(Integer dessertId) throws NullDessertIdException, InvaildDessertIdException;

    int editDessert(Integer dessertId, Dessert editDessert) throws NullDessertIdException, NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException, NullDessertPriceException;

    int deleteDessert(Integer dessertId) throws NullDessertIdException;

    void addDessertToMenu(Integer menuId, Integer dessertId);

    Dessert buyDessert(Integer dessertId, Integer quantityNum);
}
