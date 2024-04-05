package com.wongdarren.service;

import com.wongdarren.model.User;
import com.wongdarren.model.UserListResponse;
import com.wongdarren.repository.UserRepository;
import java.util.List;

public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl() {
    this.userRepository = new UserRepository();
  }

  public UserListResponse listAllUsers() {
    List<User> users = userRepository.listAll();
    return new UserListResponse(users);
  }
}