package com.wongdarren.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.List;

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
  private Long id;


  /**
   * The Date and Time.
   */
  @Column(name = "created_at")
  private OffsetDateTime dateTime;

  /**
   * The Name.
   */
  private String name;

  @OneToMany(mappedBy = "workout")
  @JsonManagedReference
  private List<Set> sets;


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

  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Set> getSets() {
    return sets;
  }

  public void setSets(List<Set> sets) {
    this.sets = sets;
  }
}