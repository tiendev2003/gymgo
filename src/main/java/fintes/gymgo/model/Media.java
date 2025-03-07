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
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_type", nullable = false)
    private String modelType;

    @Column(name = "model_id", nullable = false)
    private Long modelId;

    @Column(length = 36)
    private String uuid;

    @Column(name = "collection_name", nullable = false)
    private String collectionName;

    @Column(nullable = false)
    private String name;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(nullable = false)
    private String disk;

    @Column(name = "conversions_disk")
    private String conversionsDisk;

    @Column(nullable = false)
    private Long size;

    @Column(columnDefinition = "JSON", nullable = false)
    private String manipulations;

    @Column(columnDefinition = "JSON", nullable = false)
    private String customProperties;

    @Column(columnDefinition = "JSON", nullable = false)
    private String generatedConversions;

    @Column(columnDefinition = "JSON", nullable = false)
    private String responsiveImages;

    @Column(name = "order_column")
    private Integer orderColumn;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

   
}