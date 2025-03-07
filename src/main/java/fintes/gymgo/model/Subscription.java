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
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "package_id")
    private Long packageId;

    @Column(name = "total_amount", columnDefinition = "double default 0")
    private Double totalAmount;

    @Column(name = "payment_type", columnDefinition = "varchar(255) default 'cash'")
    private String paymentType;

    @Column(name = "txn_id")
    private String txnId;

    @Column(name = "transaction_detail", columnDefinition = "JSON")
    private String transactionDetail;

    @Column(name = "payment_status", columnDefinition = "varchar(255) default 'pending'")
    private String paymentStatus;

    @Column(name = "subscription_start_date")
    private LocalDateTime subscriptionStartDate;

    @Column(name = "subscription_end_date")
    private LocalDateTime subscriptionEndDate;

    private String status;

    @Column(name = "package_data", columnDefinition = "JSON")
    private String packageData;

    private String callback;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "package_id", insertable = false, updatable = false)
    private Package package1;

}