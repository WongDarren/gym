package com.wongdarren.service;

import com.wongdarren.model.User;
import com.wongdarren.model.UserListResponse;
import com.wongdarren.repository.UserRepository;
import jakarta.ws.rs.NotFoundException;
import java.util.List;

/**
 * The type User service.
 */
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  /**
   * Instantiates a new User service.
   */
  public UserServiceImpl() {
    this.userRepository = new UserRepository();
  }


  /**
   * @inheritDoc
   */
  public UserListResponse listAllUsers() {
    List<User> users = userRepository.listAll();
    return new UserListResponse(users);
  }

  /**
   * @inheritDoc
   */
  public User createUser(User user) {
    return userRepository.save(user);
  }

  /**
   * @inheritDoc
   */
  public void deleteUser(Long id) {
    User user = userRepository.findById(id);
    if (user == null) {
      throw new NotFoundException();
    }
    userRepository.delete(user);
  }
}