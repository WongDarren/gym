package com.wongdarren.repository;

import com.wongdarren.model.Set;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * The type Set repository.
 */
@ApplicationScoped
public class SetRepositoryImpl implements PanacheRepository<Set> {

  /**
   * Delete set.
   *
   * @param set the set
   */
  /**
   * Instantiates a new Set repository.
   */
  public SetRepositoryImpl() {
  }


  /**
   * Save set.
   *
   * @param set the set
   * @return the set
   */
  public Set save(Set set) {
    Set.persist(set);
    return set;
  }

  /**
   * Delete set.
   *
   * @param set the set
   */
  public void delete(Set set) {
    Set.delete("id", set.id);
  }


}
