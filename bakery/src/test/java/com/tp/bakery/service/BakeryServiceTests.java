package com.tp.bakery.service;

import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;
import com.tp.bakery.persistence.DessertInMemDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@ActiveProfiles("ServiceTesting")
public class BakeryServiceTests {
    @Autowired
    DessertInMemDAO toTest;

    @BeforeEach
    public void setUp(){

        List<Dessert> allDesserts = toTest.getAllDesserts();
        for (int i = 1; i < allDesserts.size(); i++) {

            toTest.deleteDessert(i);
        }

    }
    @Test
    public void addDessertGoldenPathTest() {
        try {
            Dessert test = new Dessert();

            test.setName("Lemon Pound Cake");
            test.setDescription("Made with lemons");
            Dessert added=toTest.addDessert(test);
            Dessert validate = toTest.getDessertById(1);


            assertEquals(1,added.getDessertId());
            assertEquals("Lemon Pound Cake",added.getName());
            assertEquals("Made with lemons",added.getDescription());

            assertEquals(1,validate.getDessertId());
            assertEquals("Lemon Pound Cake",validate.getName());
            assertEquals("Made with lemons",validate.getDescription());

            Dessert test2=new Dessert();
            test2.setName("Fruit Cake");
            test2.setDescription("Made with fresh fruit");
            Dessert added2=toTest.addDessert(test2);
            Dessert validate2=toTest.getDessertById(2);

            assertEquals(2,added2.getDessertId());
            assertEquals("Fruit Cake",added2.getName());
            assertEquals("Made with fresh fruit",added2.getDescription());

            assertEquals(2,validate2.getDessertId());
            assertEquals("Fruit Cake",validate2.getName());
            assertEquals("Made with fresh fruit",validate2.getDescription());


        } catch (NullDessertObjectException | NullDessertDescriptionException | NulllDessertNameException | InvaildDessertIdException | NullDessertIdException e) {
            fail();

        }
    }
    @Test
    public void addDesertNullObjectTest(){
        assertThrows(NullDessertObjectException.class,()-> toTest.addDessert(null));
    }
    @Test
    public void addDessertNullNameTest(){
        Dessert test = new Dessert();
        test.setName(null);
        test.setDescription("Sweet Icing");
        assertThrows(NulllDessertNameException.class,()->toTest.addDessert(test));
    }
    @Test
    public void addDessertNullDescriptionTest(){
        Dessert test= new Dessert();
        test.setName("Chocolate Cake");
        test.setDescription(null);
        assertThrows(NullDessertDescriptionException.class,()->toTest.addDessert(test));
    }
}
