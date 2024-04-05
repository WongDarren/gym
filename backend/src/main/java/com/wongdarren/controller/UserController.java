package com.wongdarren.controller;

import com.wongdarren.model.User;
import com.wongdarren.model.UserListResponse;
import com.wongdarren.service.UserServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;

/**
 * The type User controller.
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

  private final UserServiceImpl userService;

  /**
   * Instantiates a new User controller.
   */
  public UserController() {
    this.userService = new UserServiceImpl();
  }


  /**
   * List user list response.
   *
   * @return the user list response
   */
  @GET
  public UserListResponse list() {
    return userService.listAllUsers();
  }

  /**
   * Create response.
   *
   * @param user the user
   * @return the response
   */
  @POST
  @Transactional
  public Response create(User user) {
    User savedUser = userService.createUser(user);
    return Response.created(URI.create("/users/" + savedUser.id))
        .entity("Successfully created user " + savedUser.name)
        .build();
  }

  /**
   * Delete response.
   *
   * @param id the id
   * @return the response
   */
  @DELETE
  @Path("/{id}")
  @Transactional
  public Response delete(Long id) {
    userService.deleteUser(id);
    return Response.ok("Successfully deleted user " + id).build();
  }

}