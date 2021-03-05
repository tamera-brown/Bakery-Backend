package com.tp.bakery.persistence;

import com.tp.bakery.model.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("ServiceTesting")
public class OrderInMemDAO implements OrderDAO{
    @Override
    public List<Order> getAllOrders() {
        return null;
    }
}
