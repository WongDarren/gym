package com.wongdarren.model;

import java.util.List;


/**
 * The type Workout list response.
 */
public class WorkoutListResponse {

  private List<Workout> workouts;

  /**
   * Instantiates a new Workout list response.
   *
   * @param workout the workout
   */
  public WorkoutListResponse(List<Workout> workout) {
    this.workouts = workout;
  }

  /**
   * Gets workouts.
   *
   * @return the workouts
   */
  public List<Workout> getWorkouts() {
    return workouts;
  }

  /**
   * Sets workouts.
   *
   * @param workouts the workouts
   */
  public void setWorkouts(List<Workout> workouts) {
    this.workouts = workouts;
  }
}