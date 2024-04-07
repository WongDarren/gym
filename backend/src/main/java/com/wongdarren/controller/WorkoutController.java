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
  public Response list() {
    WorkoutListResponse workoutListResponse = workoutService.listAllWorkouts();
    if (workoutListResponse.getWorkouts().isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT).build();
    } else {
      return Response.status(Response.Status.OK).entity(workoutListResponse).build();
    }
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
    if (workout == null) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity("Workout is not provided.")
          .build();
    }
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
    if (workout == null || workout.id == null) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity("Workout or Workout id is not provided.")
          .build();
    }
    Workout updatedWorkout = workoutService.updateWorkout(workout);
    if (updatedWorkout == null) {
      return Response.status(Response.Status.NOT_FOUND)
          .entity("Workout with id " + workout.id + " not found.")
          .build();
    }
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
    if (id == null) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity("Workout id is not provided.")
          .build();
    }
    boolean isDeleted = workoutService.deleteWorkout(id);
    if (!isDeleted) {
      return Response.status(Response.Status.NOT_FOUND)
          .entity("Workout with id " + id + " not found.")
          .build();
    }
    return Response.status(Response.Status.OK)
        .entity("Workout with id " + id + " has been deleted.")
        .build();
  }

}
