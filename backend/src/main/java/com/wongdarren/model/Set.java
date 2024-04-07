package com.wongdarren.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

/**
 * The type Set.
 */
@Entity
@Table(name = "sets")
public class Set extends PanacheEntityBase {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  /**
   * The Date and Time.
   */
  @Column(name = "created_at")
  public OffsetDateTime dateTime;

  /**
   * The Workout.
   */
  @ManyToOne
  @JsonBackReference
  public Workout workout;

  /**
   * The Set number.
   */
  @Column(name = "set_number")
  public Short setNumber;

  /**
   * The Weight.
   */
  public Short weight;

  /**
   * The Reps.
   */
  public Short reps;

  /**
   * The Rpe.
   */
  public Short rpe;

  /**
   * The Warmup.
   */
  public Boolean warmup;
}