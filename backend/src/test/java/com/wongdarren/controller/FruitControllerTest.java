package com.wongdarren.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.wongdarren.model.Fruit;
import com.wongdarren.service.FruitServiceImpl;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class FruitControllerTest {

  private FruitController fruitController;
  private FruitServiceImpl fruitService;

  @BeforeEach
  public void setup() {
    fruitService = Mockito.mock(FruitServiceImpl.class);
    fruitController = new FruitController();
  }

  @Test
  public void testList() {
    Set<Fruit> fruits = new HashSet<>();
    fruits.add(new Fruit("Banana", "Long yellow fruit"));
    fruits.add(new Fruit("Apple", "Sweet red fruit"));

    when(fruitService.getAllFruits()).thenReturn(fruits);

    Response response = fruitController.list();
    assertEquals(200, response.getStatus(), "Status should be 200");
  }
}