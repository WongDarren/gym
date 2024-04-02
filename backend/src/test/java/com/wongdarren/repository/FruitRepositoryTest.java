package com.wongdarren.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.wongdarren.model.Fruit;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class FruitRepositoryTest {

  private FruitRepository fruitRepository;

  @BeforeEach
  public void setup() {
    fruitRepository = new FruitRepositoryImpl();
  }

  @Test
  public void testGetAllFruits() {
    Set<Fruit> fruits = fruitRepository.getAllFruits();
    assertEquals(2, fruits.size(), "The size of the fruit set should be 2");

    for (Fruit fruit : fruits) {
      if (!fruit.name.equals("Apple") && !fruit.name.equals("Banana")) {
        fail("The fruit set should only contain Apple and Banana");
      }
    }
  }
}