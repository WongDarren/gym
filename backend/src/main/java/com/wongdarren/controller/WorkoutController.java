package com.wongdarren.controller;

import com.wongdarren.model.WorkoutListResponse;
import com.wongdarren.service.WorkoutServiceImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/workouts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkoutController {

  private final WorkoutServiceImpl workoutService;

  /**
   * Instantiates a new Workout controller.
   */
  public WorkoutController() {
    this.workoutService = new WorkoutServiceImpl();
  }


  /**
   * List workout list response.
   *
   * @return the workout list response
   */
  @GET
  public WorkoutListResponse list() {
    return workoutService.listAllWorkouts();
  }


}
