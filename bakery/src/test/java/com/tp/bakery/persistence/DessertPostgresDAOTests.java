package com.tp.bakery.persistence;

import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DessertPostgresDAOTests {
    @Autowired
    PostgresDessertDAO toTest;
    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setUp(){
        template.update("truncate \"Menus\",\"Desserts\",\"Orders\",\"DessertMenus\",\"OrderDesserts\" restart identity;");
        template.update("insert into \"Desserts\"(\"dessertName\",\"dessertDescription\",\"dessertPrice\")\n" +
                "values('Pineapple Cake','Diced Pineapples in cream cheese icing','16.00');");

    }

    @Test
   public void addDessertGoldenPathTest(){
        try {
            Dessert partialDessert = new Dessert();
            partialDessert.setName("Pound Cake");
            partialDessert.setDescription("Moist");
            partialDessert.setPrice(25.00);

            Dessert returned = toTest.addDessert(partialDessert);

            assertEquals(2, returned.getDessertId());
            assertEquals("Pound Cake", returned.getName());
            assertEquals("Moist", returned.getDescription());
            assertEquals(25.00,returned.getPrice());

            Dessert dessert = toTest.getDessertById(1);

            assertEquals(1, dessert.getDessertId());
            assertEquals("Pineapple Cake", dessert.getName());
            assertEquals("Diced Pineapples in cream cheese icing", dessert.getDescription());
            assertEquals(16.00,dessert.getPrice());
        }catch (NullDessertObjectException | NulllDessertNameException | NullDessertDescriptionException | NullDessertIdException | NullDessertPriceException e){
            fail();
        }

    }
    @Test
    public void addDessertNullObjectTest() {

        assertThrows(NullDessertObjectException.class, () -> toTest.addDessert(null));
    }
    @Test
    public void addDessertNullNameTest(){
        Dessert test= new Dessert();
        test.setName(null);
        test.setDescription("Cake with Butter Cream Icing");
        assertThrows(NulllDessertNameException.class,()->toTest.addDessert(test));
    }
    @Test
    public void addDessertNullDescriptionTest(){
        Dessert test= new Dessert();
        test.setName("Friut Cake");
        test.setDescription(null);
        assertThrows(NullDessertDescriptionException.class,()->toTest.addDessert(test));
    }
    @Test
    public void addDessertNullPriceTest(){
        Dessert test=new Dessert();
        test.setName("Strawberry Cheesecake");
        test.setDescription("Fresh Strawberries");
        test.setPrice(null);
        assertThrows(NullDessertPriceException.class,()->toTest.addDessert(test));
    }
    @Test
    public void deleteDessertGlodenPathTest() {
        try{
            toTest.deleteDessert(1);
        } catch (NullDessertIdException e){
            fail();
        }
    }
    @Test
    public void deleteDessertNullIdTest(){
        assertThrows(NullDessertIdException.class,()->toTest.deleteDessert(null));
    }
    @Test
    public void getAllDesertsGlodenPathTest() {
        assertEquals(1,toTest.getAllDesserts().size());
        assertEquals(1, toTest.getAllDesserts().get(0).getDessertId());
        assertEquals("Pineapple Cake",toTest.getAllDesserts().get(0).getName());
        assertEquals("Diced Pineapples in cream cheese icing",toTest.getAllDesserts().get(0).getDescription());
    }
    @Test
    public void editDessertGlodenPathTest() {
        try {
            Dessert edit = toTest.getDessertById(1);
            edit.setName("Yellow Cake");
            edit.setDescription("White Icing");
            edit.setPrice(24.00);

            int returned = toTest.editDessert(edit.getDessertId(), edit);

            assertEquals(1, returned);
            assertEquals("Yellow Cake", toTest.getAllDesserts().get(0).getName());
            assertEquals("White Icing", toTest.getAllDesserts().get(0).getDescription());
            assertEquals(24.00,toTest.getAllDesserts().get(0).getPrice());


        } catch (NullDessertIdException | NullDessertObjectException | NulllDessertNameException | NullDessertDescriptionException | NullDessertPriceException e) {
            fail();
        }
    }
    @Test
    public void editDessertNullId() throws NullDessertIdException {
        Dessert test= toTest.getDessertById(1);
        test.setName("Red Velvet Cake");
        test.setDescription("White Icing");
        assertThrows(NullDessertIdException.class,()->toTest.editDessert(null,test));
    }
    @Test
    public void editDessertNullDessertObject(){
        assertThrows(NullDessertObjectException.class,()->toTest.editDessert(1,null));
    }
    @Test
    public void editDessertNullDessertName(){
        Dessert test=toTest.getAllDesserts().get(0);
        test.setName(null);
        test.setDescription("Good");
        assertThrows(NulllDessertNameException.class,()->toTest.editDessert(1,test));
    }
    @Test
    public void editDessertNullDescription(){
        Dessert test=toTest.getAllDesserts().get(0);
        test.setName("Strawberry Shortcake");
        test.setDescription(null);
        assertThrows(NullDessertDescriptionException.class,()->toTest.editDessert(1,test));
    }
    @Test
    public void editDeesertNullPrice(){
        Dessert test=new Dessert();
        test.setName("Cookie Cake");
        test.setDescription("Yummy");
        test.setPrice(null);
        assertThrows(NullDessertPriceException.class,()->toTest.editDessert(1,test));
    }


}
