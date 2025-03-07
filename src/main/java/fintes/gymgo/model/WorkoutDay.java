package fintes.gymgo.model;
 
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workout_days")
public class WorkoutDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout_id")
    private Long workoutId;

    private Long sequence;

    @Column(name = "is_rest", columnDefinition = "tinyint default 0")
    private boolean isRest;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Quan hệ với Workout (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "workout_id", insertable = false, updatable = false)
    private Workout workout;

    // Quan hệ với WorkoutDayExercise (One-to-Many)
    @OneToMany(mappedBy = "workoutDay", cascade = CascadeType.ALL)
    private List<WorkoutDayExercise> exercises;

 
}