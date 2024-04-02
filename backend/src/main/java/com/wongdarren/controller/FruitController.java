package com.wongdarren.controller;

import com.wongdarren.service.FruitServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/fruits")
public class FruitController {

  private final FruitServiceImpl fruitServiceImpl;

  public FruitController() {
    this.fruitServiceImpl = new FruitServiceImpl();
  }

  @GET
  public Response list() {
    return Response.ok(fruitServiceImpl.getAllFruits()).build();
  }
}