package com.wongdarren.controller;

import com.wongdarren.service.LegumeServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/legumes")
public class LegumeController {

  private final LegumeServiceImpl legumeServiceImpl;

  public LegumeController() {
    this.legumeServiceImpl = new LegumeServiceImpl();
  }

  @GET
  public Response list() {
    return Response.ok(legumeServiceImpl.getAllLegumes()).build();
  }
}