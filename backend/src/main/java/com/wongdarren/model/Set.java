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
  private Long id;

  /**
   * The Date and Time.
   */
  @Column(name = "created_at")
  private OffsetDateTime dateTime;


  /**
   * The Workout.
   */
  @ManyToOne
  @JsonBackReference
  private Workout workout;

  /**
   * The Number.
   */
  private Short number;

  /**
   * The Weight.
   */
  private Double weight;

  /**
   * The Reps.
   */
  private Short reps;

  /**
   * The Rpe.
   */
  private Short rpe;

  /**
   * The Warmup.
   */
  private Boolean warmup;

  /**
   * Instantiates a new Set.
   */
  public Set() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Workout getWorkout() {
    return workout;
  }

  public void setWorkout(Workout workout) {
    this.workout = workout;
  }

  public Short getNumber() {
    return number;
  }

  public void setNumber(Short number) {
    this.number = number;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Short getReps() {
    return reps;
  }

  public void setReps(Short reps) {
    this.reps = reps;
  }

  public Short getRpe() {
    return rpe;
  }

  public void setRpe(Short rpe) {
    this.rpe = rpe;
  }

  public Boolean getWarmup() {
    return warmup;
  }

  public void setWarmup(Boolean warmup) {
    this.warmup = warmup;
  }
}