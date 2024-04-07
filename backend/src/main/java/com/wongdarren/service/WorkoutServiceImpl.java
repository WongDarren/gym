package com.wongdarren.service;

import com.wongdarren.model.Workout;
import com.wongdarren.model.WorkoutListResponse;
import com.wongdarren.repository.WorkoutRepositoryImpl;
import jakarta.ws.rs.NotFoundException;
import java.util.List;

/**
 * The type Workout service.
 */
public class WorkoutServiceImpl implements WorkoutService {

  private final WorkoutRepositoryImpl workoutRepositoryImpl;


  /**
   * Instantiates a new Workout service.
   */
  public WorkoutServiceImpl() {
    this.workoutRepositoryImpl = new WorkoutRepositoryImpl();
  }


  /**
   * @inheritDoc
   */
  @Override
  public WorkoutListResponse listAllWorkouts() {
    List<Workout> workouts = workoutRepositoryImpl.listAll();
    return new WorkoutListResponse(workouts);
  }

  /**
   * @inheritDoc
   */
  @Override
  public Workout createWorkout(Workout workout) {
    return workoutRepositoryImpl.save(workout);
  }

  /**
   * @inheritDoc
   */
  @Override
  public Workout updateWorkout(Workout workout) {
    Workout existingWorkout = workoutRepositoryImpl.findById(workout.id);
    if (existingWorkout == null) {
      throw new NotFoundException();
    }
    existingWorkout.name = workout.name;
    return workoutRepositoryImpl.update(existingWorkout);
  }

  /**
   * @inheritDoc
   */
  @Override
  public void deleteWorkout(Long id) {
    Workout workout = workoutRepositoryImpl.findById(id);
    if (workout == null) {
      throw new NotFoundException();
    }
    workoutRepositoryImpl.delete(workout);
  }
}