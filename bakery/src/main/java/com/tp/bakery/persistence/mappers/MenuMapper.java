package com.tp.bakery.persistence.mappers;

import com.tp.bakery.model.Dessert;
import com.tp.bakery.model.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuMapper implements RowMapper<Menu> {

    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException {

        Menu mappedMenu = new Menu();
        mappedMenu.setMenuId(resultSet.getInt("menuId") );
        mappedMenu.setMenuName(resultSet.getString( "menuName") );

        List<Dessert> dessertItems=new ArrayList<>();
        Dessert mappedDessert =new Dessert();
        mappedDessert.setDessertId(resultSet.getInt("dessertId"));
        mappedDessert.setName(resultSet.getString("dessertName"));
        mappedDessert.setDescription(resultSet.getString("dessertDescription"));
        mappedDessert.setPrice(resultSet.getDouble("dessertPrice"));

        dessertItems.add(mappedDessert);
        mappedMenu.setDessertItems(dessertItems);

        return mappedMenu;
    }
}
