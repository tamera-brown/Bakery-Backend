package com.tp.bakery.persistence;

import com.tp.bakery.model.Order;
import com.tp.bakery.persistence.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresOrderDAO implements OrderDAO{
    @Autowired
    private JdbcTemplate template;


    @Override
    public List<Order> getAllOrders() {
        List<Order> orders=template.query("select \"orderId\", o.\"dessertId\" ,\"quantity\", dh.\"dessertName\", \n" +
                "dh.\"dessertDescription\", dh.\"dessertPrice\", dh.\"dessertImg\"\n" +
                "from \"Orders\" as o join \"DessertsHelper\" as dh\n" +
                "on o.\"dessertId\"=dh.\"dessertId\";",new OrderMapper());
        return orders;
    }
}
