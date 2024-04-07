package com.wongdarren.model;

import java.util.List;

/**
 * The type Set list response.
 */
public class SetListResponse {

  private List<Set> sets;

  /**
   * Instantiates a new Set list response.
   *
   * @param sets the sets
   */
  public SetListResponse(List<Set> sets) {
    this.sets = sets;
  }

  /**
   * Gets sets.
   *
   * @return the sets
   */
  public List<Set> getSets() {
    return sets;
  }

  /**
   * Sets sets.
   *
   * @param sets the sets
   */
  public void setSets(List<Set> sets) {
    this.sets = sets;
  }
}