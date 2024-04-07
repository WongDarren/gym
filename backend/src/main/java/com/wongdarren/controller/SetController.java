package com.wongdarren.controller;

import com.wongdarren.model.Set;
import com.wongdarren.model.SetListResponse;
import com.wongdarren.service.SetServiceImpl;
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

/**
 * The type Set controller.
 */
@Path("/sets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SetController {

  private final SetServiceImpl setService;

  /**
   * Instantiates a new Set controller.
   */
  public SetController() {
    this.setService = new SetServiceImpl();
  }


  /**
   * List set list response.
   *
   * @return the set list response
   */
  @GET
  public SetListResponse list() {
    return setService.listAllSets();
  }

  /**
   * Create set.
   *
   * @param set the set
   * @return the response
   */
  @POST
  @Transactional
  public Response createSet(Set set) {
    Set createdSet = setService.createSet(set);
    return Response.status(Response.Status.CREATED).entity(createdSet).build();
  }

  @PUT
  @Transactional
  public Response updateSet(Set set) {
    Set updatedSet = setService.updateSet(set);
    return Response.status(Response.Status.OK).entity(updatedSet).build();
  }

  @DELETE
  @Transactional
  @Path("/{id}")
  public Response deleteSet(Long id) {
    setService.deleteSet(id);
    return Response.status(Response.Status.OK)
        .entity("Set with id " + id + " has been deleted.")
        .build();
  }

}
