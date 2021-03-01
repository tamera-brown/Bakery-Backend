package com.tp.bakery.persistence;

import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;
import com.tp.bakery.persistence.mappers.DessertMapper;
import com.tp.bakery.persistence.mappers.IntegerMapper;
import com.tp.bakery.persistence.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile({"Application","daoTesting"})
public class PostgresDessertDAO implements DessertDAO {

    @Autowired
   private JdbcTemplate template;

    @Override
    public List<Dessert> getAllDesserts() {
        List<Dessert> allDesserts=template.query("select \"dessertId\",\"dessertName\",\"dessertDescription\", \"dessertPrice\" from \"Desserts\";",new DessertMapper());
        return allDesserts;
    }

    @Override
    public Dessert addDessert(Dessert dessert) throws NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException, NullDessertPriceException {
        if(dessert==null){
            throw new NullDessertObjectException("Cannot add null dessert object");
        }
        if(dessert.getName()==null){
            throw new NulllDessertNameException("Cannot add dessert with null name");
        }
        if(dessert.getDescription()==null){
            throw new NullDessertDescriptionException("Cannot add a dessert with null description");
        }
        if(dessert.getPrice()==null){
            throw new NullDessertPriceException("Cannot add a dessert with null price");
        }
        Integer dessertId=template.queryForObject("insert into \"Desserts\" (\"dessertName\",\"dessertDescription\",\"dessertPrice\") values(?,?,?) returning \"dessertId\";\n" +
                "\n",new IntegerMapper("dessertId"),dessert.getName(),dessert.getDescription(),dessert.getPrice()) ;

        dessert.setDessertId(dessertId);

        return dessert;
    }

    @Override
    public Dessert getDessertById(Integer dessertId) throws NullDessertIdException {
        if(dessertId==null){
            throw new NullDessertIdException("Cannot get dessert with null Id");
        }

        Dessert retreived=template.queryForObject("select \"dessertId\", \"dessertName\", \"dessertDescription\", \"dessertPrice\" from \"Desserts\" where \"dessertId\"='"+dessertId+"'",new DessertMapper());

        return retreived;

    }

    @Override
    public int editDessert(Integer dessertId, Dessert editdessert) throws NullDessertIdException, NullDessertObjectException, NullDessertDescriptionException,NulllDessertNameException,NullDessertPriceException{
        if(dessertId==null){
            throw new NullDessertIdException("Cannot edit dessert with null id");
        }
        if(editdessert==null){
            throw new NullDessertObjectException("Cannot edit dessert with null dessert");
        }
        if(editdessert.getDescription()==null){
            throw new NullDessertDescriptionException("Cannot edit dessert with null description");
        }
        if(editdessert.getName()==null){
            throw new NulllDessertNameException("Cannot edit dessert with null name");
        }
        if(editdessert.getPrice()==null){
            throw new NullDessertPriceException("Cannot edit dessert with null price");
        }
        int edited=template.update("update \"Desserts\"\n" +
                "set \"dessertName\"=?, \"dessertDescription\"=?, \"dessertPrice\"=? \n" +
                "where \"dessertId\"=?;",

                editdessert.getName(),editdessert.getDescription(),editdessert.getPrice(),dessertId);

        return edited;

    }

    @Override
    public int deleteDessert(Integer dessertId) throws NullDessertIdException {
        if(dessertId==null){
            throw new NullDessertIdException("Cannot delete dessert with null id");
        }
        int deleted=template.update("delete from \"Desserts\" where \"dessertId\"=?;",dessertId);
        return deleted;

    }

    @Override
    public void addDessertToMenu(Integer menuId, Integer dessertId) {
        template.update("insert into \"DessertMenus\"(\"menuId\",\"dessertId\")\n" +
                "select \"menuId\",\"dessertId\" from \"DessertsHelper\"\n" +
                "where \"menuId\"=? and \"dessertId\"=?;\n" +
                "\n", menuId,dessertId );
    }

    @Override
    public Dessert buyDessert(Integer dessertId, Integer quantityNum) {
        //Integer input=template.queryForObject("", new OrderMapper());
        return null;
    }


}



