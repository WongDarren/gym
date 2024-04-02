package com.wongdarren.service;

import com.wongdarren.model.Legume;
import com.wongdarren.repository.LegumeRepositoryImpl;
import java.util.Set;

public class LegumeServiceImpl implements LegumeService {

  private final LegumeRepositoryImpl legumeRepositoryImpl;

  public LegumeServiceImpl() {
    this.legumeRepositoryImpl = new LegumeRepositoryImpl();
  }

  public Set<Legume> getAllLegumes() {
    return legumeRepositoryImpl.getAllLegumes();
  }
}