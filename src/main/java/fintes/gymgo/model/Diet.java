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
@Table(name = "diets")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "categorydiet_id")
    private Long categoryDietId;

    private String calories;
    private String carbs;
    private String protein;
    private String fat;
    private String servings;

    @Column(name = "total_time")
    private String totalTime;

    @Column(name = "is_featured")
    private String isFeatured;

    @Column(columnDefinition = "varchar(255) default 'active'")
    private String status;

    @Column(columnDefinition = "TEXT")
    private String ingredients;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_premium", columnDefinition = "tinyint default 0")
    private boolean isPremium;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "categorydiet_id", insertable = false, updatable = false)
    private CategoryDiet category;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
    private List<AssignDiet> assignedUsers;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
    private List<UserFavouriteDiet> favouritedBy;
 
}