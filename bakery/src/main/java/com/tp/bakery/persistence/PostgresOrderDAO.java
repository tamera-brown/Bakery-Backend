package com.tp.bakery.persistence;

import com.tp.bakery.execptions.NullDessertIdException;
import com.tp.bakery.model.Dessert;
import com.tp.bakery.model.Order;
import com.tp.bakery.persistence.mappers.DessertMapper;
import com.tp.bakery.persistence.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile({"Application","daoTesting"})
public class PostgresOrderDAO implements OrderDAO {

    @Autowired
    private JdbcTemplate template;


    @Override
    public List<Order> getAllOrders() throws NullDessertIdException {
        List<Order> orders = template.query("select \"orderId\", o.\"dessertId\" ,\"quantity\", dh.\"dessertName\", \n" +
                "dh.\"dessertDescription\", dh.\"dessertPrice\", dh.\"dessertImg\"\n" +
                "from \"Orders\" as o join \"DessertsHelper\" as dh\n" +
                "on o.\"dessertId\"=dh.\"dessertId\";", new OrderMapper());

        for(Order order :orders){
            order.setBagItem(getDessertById(order.getDessertId()));
        }
        return orders;
    }

    @Override
    public Order veiwOrderById(Integer orderId) throws NullDessertIdException {
        Order retrieved = template.queryForObject("select \"orderId\", o.\"dessertId\" ,\"quantity\", dh.\"dessertName\",\n" +
                "                dh.\"dessertDescription\", dh.\"dessertPrice\", dh.\"dessertImg\"\n" +
                "                from \"Orders\" as o join \"DessertsHelper\" as dh\n" +
                "                on o.\"dessertId\" = dh.\"dessertId\" and o.\"orderId\"=?;", new OrderMapper(), orderId);
        retrieved.setBagItem(getDessertById(retrieved.getDessertId()));
        return retrieved;
    }

    @Override
    public int deletOrder(Integer orderId) {
        int deleted = template.update("delete from \"Orders\" where \"orderId\"=?;", orderId);
        return deleted;
    }

    public Dessert getDessertById(Integer dessertId) throws NullDessertIdException {
        if (dessertId == null) {
            throw new NullDessertIdException("Cannot get dessert with null Id");
        }

        Dessert retreived = template.queryForObject("select \"dessertId\", \"dessertName\", \"dessertDescription\", \"dessertPrice\", \"dessertImg\" from \"Desserts\" where \"dessertId\"='" + dessertId + "'", new DessertMapper());

        return retreived;

    }
}