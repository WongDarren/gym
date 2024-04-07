package com.wongdarren.controller;

import com.wongdarren.model.Workout;
import com.wongdarren.model.WorkoutListResponse;
import com.wongdarren.service.WorkoutServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

  /**
   * Create workout.
   *
   * @param workout the workout
   * @return the response
   */
  @POST
  @Transactional
  public Response createWorkout(Workout workout) {
    Workout createdWorkout = workoutService.createWorkout(workout);
    return Response.status(Response.Status.CREATED).entity(createdWorkout).build();
  }

  /**
   * Update workout.
   *
   * @param workout the workout
   * @return the response
   */
  @PUT
  @Transactional
  public Response updateWorkout(Workout workout) {
    Workout updatedWorkout = workoutService.updateWorkout(workout);
    return Response.status(Response.Status.OK).entity(updatedWorkout).build();
  }

  /**
   * Delete workout.
   *
   * @param id the id
   * @return the response
   */
  @DELETE
  @Transactional
  @Path("/{id}")
  public Response deleteWorkout(Long id) {
    workoutService.deleteWorkout(id);
    return Response.status(Response.Status.OK)
        .entity("Workout with id " + id + " has been deleted.")
        .build();
  }

}
