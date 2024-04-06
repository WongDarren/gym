package com.wongdarren.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

/**
 * The type Workout.
 */
@Entity
@Table(name = "workouts")
public class Workout extends PanacheEntityBase {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;


  /**
   * The Date.
   */
  public OffsetDateTime created_at;

  /**
   * The Name.
   */
  public String name;


  /**
   * Instantiates a new Workout.
   */
  public Workout() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OffsetDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(OffsetDateTime created_at) {
    this.created_at = created_at;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}