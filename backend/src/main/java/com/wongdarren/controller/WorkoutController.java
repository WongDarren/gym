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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

/**
 * The type Workout controller.
 */
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
  @Operation(summary = "List all workouts")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", description = "Workouts found",
          content = @Content(schema = @Schema(implementation = WorkoutListResponse.class))),
      @APIResponse(responseCode = "204", description = "No workouts found"),
  }
  )
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
  @Operation(summary = "Create a new workout")
  @APIResponses(value = {
      @APIResponse(responseCode = "201", description = "Workout created",
          content = @Content(schema = @Schema(implementation = Workout.class))),
      @APIResponse(responseCode = "400", description = "Workout is not provided"),
  }
  )
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
  @Operation(summary = "Update an existing workout")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", description = "Workout updated",
          content = @Content(schema = @Schema(implementation = Workout.class))),
      @APIResponse(responseCode = "400", description = "Workout or Workout id is not provided"),
      @APIResponse(responseCode = "404", description = "Workout not found"),
  }
  )
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
  @Operation(summary = "Delete an existing workout")
  @APIResponses(value = {
      @APIResponse(responseCode = "200", description = "Workout deleted"),
      @APIResponse(responseCode = "400", description = "Workout id is not provided"),
      @APIResponse(responseCode = "404", description = "Workout not found"),
  }
  )
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
