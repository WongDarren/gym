package com.wongdarren.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
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
  public Long id;


  /**
   * The Date and Time.
   */
  @Column(name = "created_at")
  public OffsetDateTime dateTime;

  /**
   * The Name.
   */
  public String name;

  @OneToMany(mappedBy = "workout", fetch = FetchType.EAGER)
  @JsonManagedReference
  public List<Set> sets;

  @PrePersist
  public void prePersist() {
    if (dateTime == null) {
      dateTime = OffsetDateTime.now();
    }
  }

}