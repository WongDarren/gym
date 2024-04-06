package com.wongdarren.repository;

import com.wongdarren.model.Workout;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


/**
 * The type Workout repository.
 */
@ApplicationScoped
public class WorkoutRepositoryImpl implements PanacheRepository<Workout> {


  /**
   * Instantiates a new Workout repository.
   */
  public WorkoutRepositoryImpl() {
  }


  /**
   * Save workout.
   *
   * @param workout the workout
   * @return the workout
   */
  public Workout save(Workout workout) {
    workout.persist();
    return workout;
  }


  public void delete(Workout workout) {
    workout.delete();
  }

}