package com.wongdarren.service;

import com.wongdarren.model.User;
import com.wongdarren.model.UserListResponse;


/**
 * The interface User service.
 */
public interface UserService {

  /**
   * List all users user list response.
   *
   * @return the user list response
   */
  UserListResponse listAllUsers();

  /**
   * Create user.
   *
   * @param user the user
   * @return the user
   */
  User createUser(User user);

  /**
   * Delete user.
   *
   * @param id the id
   */
  void deleteUser(Long id);

}
