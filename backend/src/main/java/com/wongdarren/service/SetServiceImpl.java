package com.wongdarren.service;

import com.wongdarren.model.Set;
import com.wongdarren.model.SetListResponse;
import com.wongdarren.model.Workout;
import com.wongdarren.repository.SetRepositoryImpl;
import com.wongdarren.repository.WorkoutRepositoryImpl;
import jakarta.ws.rs.NotFoundException;
import java.util.List;

/**
 * The type Set service.
 */
public class SetServiceImpl implements SetService {

  private final SetRepositoryImpl setRepositoryImpl;
  private final WorkoutRepositoryImpl workoutRepositoryImpl;


  /**
   * Instantiates a new Workout service.
   */
  public SetServiceImpl() {
    this.setRepositoryImpl = new SetRepositoryImpl();
    this.workoutRepositoryImpl = new WorkoutRepositoryImpl();
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
  public Set createSet(Set set, Long workoutId) {
    Workout workout = workoutRepositoryImpl.findById(workoutId);
    if (workout == null) {
      throw new NotFoundException("Workout not found");
    }
    set.workout = workout;
    return setRepositoryImpl.save(set);
  }

  /**
   * @inheritDoc
   */
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

    return setRepositoryImpl.update(existingSet);
  }

  /**
   * @inheritDoc
   */
  @Override
  public boolean deleteSet(Long id) {
    Set set = Set.findById(id);
    if (set != null) {
      set.delete();
      return true;
    }
    return false;
  }
}