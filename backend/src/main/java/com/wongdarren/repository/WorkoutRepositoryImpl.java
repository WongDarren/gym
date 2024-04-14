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
   * Find by id workout.
   *
   * @param id the id
   * @return the workout
   */
  public Workout findById(Long id) {
    return Workout.findById(id);
  }

  /**
   * Save workout.
   *
   * @param workout the workout
   * @return the workout
   */
  public Workout save(Workout workout) {
    Workout.persist(workout);
    return workout;
  }

  /**
   * Update workout.
   *
   * @param workout the workout
   * @return the workout
   */
  public Workout update(Workout workout) {
    workout.persist();
    return workout;
  }

  /**
   * Delete workout.
   *
   * @param workout the workout
   */
  public void delete(Workout workout) {
    Workout.delete("id", workout.id);
  }

}