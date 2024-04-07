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
   * Update set.
   *
   * @param set the set
   * @return the set
   */
  public Set update(Set set) {
    set.persist();
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
