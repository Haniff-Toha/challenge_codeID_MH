package com.test_axa.hr.model.entity;

import com.test_axa.hr.model.enumeration.PermissionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission_type", nullable = false)
    private PermissionType permissionType;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
