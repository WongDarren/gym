package com.wongdarren.repository;

import com.wongdarren.model.Legume;
import java.util.Set;

public interface LegumeRepository {

  Set<Legume> getAllLegumes();
}