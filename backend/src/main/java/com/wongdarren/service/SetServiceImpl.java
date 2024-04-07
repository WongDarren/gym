package com.wongdarren.service;

import com.wongdarren.model.Set;
import com.wongdarren.model.SetListResponse;
import com.wongdarren.repository.SetRepositoryImpl;
import jakarta.ws.rs.NotFoundException;
import java.util.List;

/**
 * The type Set service.
 */
public class SetServiceImpl implements SetService {

  private final SetRepositoryImpl setRepositoryImpl;


  /**
   * Instantiates a new Workout service.
   */
  public SetServiceImpl() {
    this.setRepositoryImpl = new SetRepositoryImpl();
  }


  /**
   * @inheritDoc
   */
  @Override
  public SetListResponse listAllSets() {
    List<Set> sets = setRepositoryImpl.listAll();
    return new SetListResponse(sets);
  }

  /**
   * @inheritDoc
   */
  @Override
  public Set createSet(Set set) {
    return setRepositoryImpl.save(set);
  }

  @Override
  public Set updateSet(Set set) {
    Set existingSet = setRepositoryImpl.findById(set.id);
    if (existingSet == null) {
      throw new NotFoundException();
    }

    existingSet.setNumber = set.setNumber;
    existingSet.weight = set.weight;
    existingSet.reps = set.reps;
    existingSet.rpe = set.rpe;
    existingSet.warmup = set.warmup;

    return setRepositoryImpl.update(existingSet);
  }

  /**
   * @inheritDoc
   */
  @Override
  public void deleteSet(Long id) {
    Set set = setRepositoryImpl.findById(id);
    if (set == null) {
      throw new NotFoundException();
    }
    setRepositoryImpl.delete(set);
  }
}