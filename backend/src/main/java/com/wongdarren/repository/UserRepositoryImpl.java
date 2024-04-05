package com.wongdarren.repository;

import com.wongdarren.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


/**
 * The type User repository.
 */
@ApplicationScoped
public class UserRepositoryImpl implements PanacheRepository<User> {


  /**
   * Instantiates a new User repository.
   */
  public UserRepositoryImpl() {
  }


  /**
   * Save user.
   *
   * @param user the user
   * @return the user
   */
  public User save(User user) {
    user.persist();
    return user;
  }


  public void delete(User user) {
    user.delete();
  }

}