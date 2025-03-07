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
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String instruction;

    @Column(columnDefinition = "TEXT")
    private String tips;

    @Column(name = "video_type")
    private String videoType;

    @Column(columnDefinition = "TEXT")
    private String videoUrl;

    @Column(name = "bodypart_ids", columnDefinition = "TEXT")
    private String bodypartIds;

    private String duration;

    private String based;

    private String type;

    @Column(name = "equipment_id")
    private Long equipmentId;

    @Column(name = "level_id")
    private Long levelId;

    @Column(columnDefinition = "JSON")
    private String sets;

    @Column(columnDefinition = "varchar(255) default 'active'")
    private String status;

    @Column(name = "is_premium", columnDefinition = "tinyint default 0")
    private boolean isPremium;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "equipment_id", insertable = false, updatable = false)
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "level_id", insertable = false, updatable = false)
    private Level level;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<WorkoutDayExercise> workoutDayExercises;

    
}