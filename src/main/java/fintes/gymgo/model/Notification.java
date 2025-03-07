package fintes.gymgo.model;

 
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
public class Notification {

    @Id
    @Column(length = 36)
    private String id;

    @Column(nullable = false)
    private String type;

    @Column(name = "notifiable_type", nullable = false)
    private String notifiableType;

    @Column(name = "notifiable_id", nullable = false)
    private Long notifiableId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String data;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
 
}