package fintes.gymgo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_verified_at")
    private LocalDateTime emailVerifiedAt;

    @Column(name = "user_type", nullable = false, columnDefinition = "varchar(255) default 'user'")
    private String userType;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'pending'")
    private String status;

    @Column(name = "login_type")
    private String loginType;

    private String gender;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "player_id")
    private String playerId;

    @Column(name = "is_subscribe", columnDefinition = "tinyint default 0")
    private boolean isSubscribe;

    @Column(name = "last_notification_seen")
    private LocalDateTime lastNotificationSeen;

    @Column(name = "remember_token", length = 100)
    private String rememberToken;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AssignDiet> assignedDiets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AssignWorkout> assignedWorkouts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFavouriteDiet> favouriteDiets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFavouriteWorkout> favouriteWorkouts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

}