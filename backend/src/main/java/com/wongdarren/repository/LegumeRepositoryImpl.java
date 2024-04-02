package com.wongdarren.repository;

import com.wongdarren.model.Legume;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class LegumeRepositoryImpl implements LegumeRepository {

  private final Set<Legume> legumes = Collections.synchronizedSet(new LinkedHashSet<>());

  public LegumeRepositoryImpl() {
    legumes.add(new Legume("Carrot", "Root vegetable, usually orange"));
    legumes.add(new Legume("Zucchini", "Summer squash"));
  }

  public Set<Legume> getAllLegumes() {
    return legumes;
  }
}