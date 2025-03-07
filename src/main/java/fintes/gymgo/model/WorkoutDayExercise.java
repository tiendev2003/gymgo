package fintes.gymgo.model;

 import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workout_day_exercises")
public class WorkoutDayExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout_id")
    private Long workoutId;

    @Column(name = "workout_day_id")
    private Long workoutDayId;

    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(columnDefinition = "JSON")
    private String sets;

    private Long sequence;

    private String duration;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Quan hệ với Workout (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "workout_id", insertable = false, updatable = false)
    private Workout workout;

    // Quan hệ với WorkoutDay (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "workout_day_id", insertable = false, updatable = false)
    private WorkoutDay workoutDay;

    // Quan hệ với Exercise (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "exercise_id", insertable = false, updatable = false)
    private Exercise exercise;
 
}