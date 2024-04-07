package com.wongdarren.service;

import com.wongdarren.model.Workout;
import com.wongdarren.model.WorkoutListResponse;


/**
 * The interface Workout service.
 */
public interface WorkoutService {

  /**
   * List all workouts workout list response.
   *
   * @return the workout list response
   */
  WorkoutListResponse listAllWorkouts();

  /**
   * Create workout.
   *
   * @param workout the workout
   * @return the workout
   */
  Workout createWorkout(Workout workout);

  /**
   * Update workout.
   *
   * @param workout the workout
   * @return the workout
   */
  Workout updateWorkout(Workout workout);


  /**
   * Delete workout.
   *
   * @param id the id
   * @return
   */
  boolean deleteWorkout(Long id);


}
