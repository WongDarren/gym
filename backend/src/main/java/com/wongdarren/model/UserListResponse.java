package com.wongdarren.model;

import java.util.List;


/**
 * The type User list response.
 */
public class UserListResponse {

  private List<User> users;

  /**
   * Instantiates a new User list response.
   *
   * @param users the users
   */
  public UserListResponse(List<User> users) {
    this.users = users;
  }

  /**
   * Gets users.
   *
   * @return the users
   */
  public List<User> getUsers() {
    return users;
  }

  /**
   * Sets users.
   *
   * @param users the users
   */
  public void setUsers(List<User> users) {
    this.users = users;
  }
}