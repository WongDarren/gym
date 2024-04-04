package com.wongdarren.controller;

import com.wongdarren.service.FruitServiceImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/fruits")
public class FruitController {

  private final FruitServiceImpl fruitServiceImpl;

  public FruitController() {
    this.fruitServiceImpl = new FruitServiceImpl();
  }

  @Operation(summary = "List all fruits", description = "Fetches all fruits from the repository")
  @APIResponse(responseCode = "200", description = "Successfully retrieved list of fruits")
  @APIResponse(responseCode = "404", description = "Fruits not found")
  @GET
  public Response list() {
    return Response.ok(fruitServiceImpl.getAllFruits()).build();
  }
}