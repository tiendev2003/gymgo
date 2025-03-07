package fintes.gymgo.model;

 
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_gateways")
public class PaymentGateway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String type;

    @Column(columnDefinition = "tinyint default 1")
    private byte status;

    @Column(name = "is_test", columnDefinition = "tinyint default 1")
    private byte isTest;

    @Column(name = "test_value", columnDefinition = "JSON")
    private String testValue;

    @Column(name = "live_value", columnDefinition = "JSON")
    private String liveValue;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
 
}