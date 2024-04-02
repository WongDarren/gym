package com.wongdarren.repository;

import com.wongdarren.model.Fruit;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class FruitRepositoryImpl implements FruitRepository {

  private final Set<Fruit> fruits = Collections.synchronizedSet(new LinkedHashSet<>());

  public FruitRepositoryImpl() {
    fruits.add(new Fruit("Apple", "Sweet red fruit"));
    fruits.add(new Fruit("Banana", "Long yellow fruit"));
  }

  public Set<Fruit> getAllFruits() {
    return fruits;
  }
}