package com.tp.bakery.persistence;

import com.tp.bakery.model.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> getAllOrders();
}
