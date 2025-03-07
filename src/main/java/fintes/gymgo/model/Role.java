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
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(name = "guard_name", nullable = false)
    private String guardName;

    @Column(columnDefinition = "tinyint default 1")
    private byte status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<ModelHasRole> modelRoles;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<RoleHasPermission> rolePermissions;

    // Getters và Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGuardName() { return guardName; }
    public void setGuardName(String guardName) { this.guardName = guardName; }
    public byte getStatus() { return status; }
    public void setStatus(byte status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public List<ModelHasRole> getModelRoles() { return modelRoles; }
    public void setModelRoles(List<ModelHasRole> modelRoles) { this.modelRoles = modelRoles; }
    public List<RoleHasPermission> getRolePermissions() { return rolePermissions; }
    public void setRolePermissions(List<RoleHasPermission> rolePermissions) { this.rolePermissions = rolePermissions; }
}