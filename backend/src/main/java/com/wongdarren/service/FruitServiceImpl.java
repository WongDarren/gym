package com.wongdarren.service;

import com.wongdarren.model.Fruit;
import com.wongdarren.repository.FruitRepositoryImpl;
import java.util.Set;

public class FruitServiceImpl implements FruitService {

  private final FruitRepositoryImpl fruitRepositoryImpl;

  public FruitServiceImpl() {
    this.fruitRepositoryImpl = new FruitRepositoryImpl();
  }

  public Set<Fruit> getAllFruits() {
    return fruitRepositoryImpl.getAllFruits();
  }
}