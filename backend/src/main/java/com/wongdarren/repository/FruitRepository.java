package com.wongdarren.repository;

import com.wongdarren.model.Fruit;
import java.util.Set;

public interface FruitRepository {

  Set<Fruit> getAllFruits();
}