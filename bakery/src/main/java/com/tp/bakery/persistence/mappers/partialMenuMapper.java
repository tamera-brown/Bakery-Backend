package com.tp.bakery.persistence.mappers;

import com.tp.bakery.model.Menu;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class partialMenuMapper implements RowMapper<Menu> {
    @Override
    public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
        Menu partialmappedMenu = new Menu();
        partialmappedMenu.setMenuId(resultSet.getInt("menuId") );
        partialmappedMenu.setMenuName(resultSet.getString( "menuName") );

        return partialmappedMenu;
    }
}
