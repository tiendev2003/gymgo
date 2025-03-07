package fintes.gymgo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "model_has_roles")
public class ModelHasRole {

    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Id
    @Column(name = "model_type")
    private String modelType;

    @Id
    @Column(name = "model_id")
    private Long modelId;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    // Getters và Setters
    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }
    public String getModelType() { return modelType; }
    public void setModelType(String modelType) { this.modelType = modelType; }
    public Long getModelId() { return modelId; }
    public void setModelId(Long modelId) { this.modelId = modelId; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}