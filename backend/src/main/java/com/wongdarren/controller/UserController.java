package com.wongdarren.controller;

import com.wongdarren.model.UserListResponse;
import com.wongdarren.service.UserServiceImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

  private final UserServiceImpl userService;

  public UserController() {
    this.userService = new UserServiceImpl();
  }


  @GET
  public UserListResponse list() {
    return userService.listAllUsers();
  }
}