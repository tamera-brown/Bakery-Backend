package com.tp.bakery.persistence;


import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("ServiceTesting")
public class DessertInMemDAO implements DessertDAO {
    private List<Dessert> allDesserts = new ArrayList<>();

    @Override
    public List<Dessert> getAllDesserts() {
        List<Dessert> copy = new ArrayList<>();
        for (Dessert copies : allDesserts) {
            copy.add(new Dessert(copies));
        }
        return allDesserts;
    }

    @Override
    public Dessert addDessert(Dessert dessert) throws NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException {
        Integer id = 0;
        if (dessert == null) {
            throw new NullDessertObjectException("Cannot add null dessert object");
        }
        if (dessert.getName() == null) {
            throw new NulllDessertNameException("Cannot add dessert with null name");
        }
        if (dessert.getDescription() == null) {
            throw new NullDessertDescriptionException("Cannot add a dessert with null description");
        }

        for(Dessert toCheck : allDesserts){
            if(toCheck.getDessertId()>id){
                id=toCheck.getDessertId();
            }
        }
        id++;

        Dessert copy=new Dessert(dessert);
        copy.setDessertId(id);
        allDesserts.add(copy);


        return copy;


    }

    @Override
    public Dessert getDessertById(Integer dessertId) throws NullDessertIdException, InvaildDessertIdException {
        if (dessertId == null) {
            throw new NullDessertIdException("No Dessert with null id");

        }
        for (Dessert dessert : allDesserts) {
            if (dessert.getDessertId().equals(dessertId)) {
                return dessert;
            }
        }
        throw new InvaildDessertIdException("No Dessert with id " + dessertId);
    }

    @Override
    public int editDessert(Integer dessertId, Dessert editDessert) {
        return 0;
    }

    @Override
    public int deleteDessert(Integer dessertId) {
        return 0;
    }

    @Override
    public void addDessertToMenu(Integer menuId, Integer dessertId) {

    }

    @Override
    public Dessert buyDessert(Integer dessertId, Integer quantityNum) {
        return null;
    }
}
