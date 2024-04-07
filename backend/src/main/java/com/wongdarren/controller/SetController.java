package com.wongdarren.controller;

import com.wongdarren.model.SetListResponse;
import com.wongdarren.service.SetServiceImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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


}
