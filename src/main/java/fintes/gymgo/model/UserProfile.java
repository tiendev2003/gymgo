package fintes.gymgo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String address;

    private String country;

    private String state;

    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    private String bio;

    @Column(name = "profile_image")
    private String profileImage;

    private Float height;

    private Float weight;

    @Column(name = "current_bmi")
    private Float currentBmi;

    @Column(name = "desired_weight")
    private Float desiredWeight;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Quan hệ với User (One-to-One)
    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
 
}