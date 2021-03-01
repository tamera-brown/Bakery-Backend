package com.tp.bakery.service;

import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;
import com.tp.bakery.model.Menu;
import com.tp.bakery.persistence.DessertDAO;
import com.tp.bakery.persistence.MenuDAO;
import com.tp.bakery.persistence.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BakeryService {
    @Autowired
    DessertDAO Dessertdao;
    @Autowired
    MenuDAO Menudao;
    @Autowired
    OrderDAO Orderdao;

    public List<Dessert> getAllDesserts() {
        return Dessertdao.getAllDesserts();
    }

    public Dessert addDessert(Dessert dessert) throws NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException, NullDessertPriceException {
        return Dessertdao.addDessert(dessert);

    }

    public Dessert getDessertById(Integer dessertId) throws NullDessertIdException, InvaildDessertIdException {
        return Dessertdao.getDessertById(dessertId);
    }


    public int editDessert(Integer dessertId, Dessert dessert) throws NullDessertIdException, NullDessertObjectException,NulllDessertNameException, NullDessertDescriptionException,NullDessertPriceException {
        return Dessertdao.editDessert(dessertId,dessert);
    }

    public int deleteDessert(Integer dessertId) throws NullDessertIdException {
        return Dessertdao.deleteDessert(dessertId);
    }

    public void addDessertToMenu(Integer menuId, Integer dessertId) {
        Dessertdao.addDessertToMenu(menuId,dessertId);
    }
    public List<Menu> getAllMenus() {
        return Menudao.getAllMenus();
    }

    public Menu addMenu(Menu newMenu) {
        return Menudao.addMenu(newMenu);
    }

    public Menu viewMenusById(Integer menuId) {
        return Menudao.viewMenuById(menuId);
    }


    public Dessert buyDessert(Integer dessertId, Integer quantityNum) {
         Dessertdao.buyDessert(dessertId,quantityNum);
        return null;
    }
}
