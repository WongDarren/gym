package com.wongdarren.service;

import com.wongdarren.model.Set;
import com.wongdarren.model.SetListResponse;

/**
 * The interface Set service.
 */
public interface SetService {

  /**
   * List all sets set list response.
   *
   * @return the set list response
   */
  SetListResponse listAllSets();

  /**
   * Create set.
   *
   * @param set the set
   * @return the set
   */
  Set createSet(Set set);

  /**
   * Delete set.
   *
   * @param id the id
   */
  void deleteSet(Long id);

}
