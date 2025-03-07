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
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "level_id")
    private Long levelId;

    @Column(name = "workout_type_id")
    private Long workoutTypeId;

    @Column(columnDefinition = "varchar(255) default 'active'")
    private String status;

    @Column(name = "is_premium", columnDefinition = "tinyint default 0")
    private boolean isPremium;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Quan hệ với Level (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "level_id", insertable = false, updatable = false)
    private Level level;

    // Quan hệ với WorkoutType (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "workout_type_id", insertable = false, updatable = false)
    private WorkoutType workoutType;

    // Quan hệ với WorkoutDay (One-to-Many)
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<WorkoutDay> days;

    // Quan hệ với AssignWorkouts (One-to-Many)
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<AssignWorkout> assignedUsers;

    // Quan hệ với UserFavouriteWorkouts (One-to-Many)
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<UserFavouriteWorkout> favouritedBy;

    // Getters và Setters 
}