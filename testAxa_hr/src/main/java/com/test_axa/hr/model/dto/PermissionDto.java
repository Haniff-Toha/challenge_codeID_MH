package com.test_axa.hr.model.dto;

import com.test_axa.hr.model.enumeration.PermissionType;

public record PermissionDto(Long permissionId, PermissionType permissionType, Long roleId) {
    
}
