package com.wongdarren.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.wongdarren.model.Fruit;
import com.wongdarren.repository.FruitRepository;
import io.quarkus.test.junit.QuarkusTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class FruitServiceTest {

  private FruitServiceImpl fruitService;
  private FruitRepository fruitRepository;

  @BeforeEach
  public void setup() {
    fruitRepository = Mockito.mock(FruitRepository.class);
    fruitService = new FruitServiceImpl();
  }

  @Test
  public void testGetAllFruits() {
    Set<Fruit> fruits = new HashSet<>();
    fruits.add(new Fruit("Banana", "Long yellow fruit"));
    fruits.add(new Fruit("Apple", "Sweet red fruit"));

    when(fruitRepository.getAllFruits()).thenReturn(fruits);
    Set<Fruit> resultFruits = fruitService.getAllFruits();
    assertNotNull(resultFruits, "Result should not be null");
  }
}