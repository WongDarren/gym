package com.wongdarren.service;

import com.wongdarren.model.User;
import com.wongdarren.model.UserListResponse;
import com.wongdarren.repository.UserRepositoryImpl;
import jakarta.ws.rs.NotFoundException;
import java.util.List;

/**
 * The type User service.
 */
public class UserServiceImpl implements UserService {

  private final UserRepositoryImpl userRepositoryImpl;


  /**
   * Instantiates a new User service.
   */
  public UserServiceImpl() {
    this.userRepositoryImpl = new UserRepositoryImpl();
  }


  /**
   * @inheritDoc
   */
  public UserListResponse listAllUsers() {
    List<User> users = userRepositoryImpl.listAll();
    return new UserListResponse(users);
  }

  /**
   * @inheritDoc
   */
  public User createUser(User user) {
    return userRepositoryImpl.save(user);
  }

  /**
   * @inheritDoc
   */
  public void deleteUser(Long id) {
    User user = userRepositoryImpl.findById(id);
    if (user == null) {
      throw new NotFoundException();
    }
    userRepositoryImpl.delete(user);
  }
}