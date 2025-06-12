package com.test_axa.hr.model.dto;

import com.test_axa.hr.model.enumeration.PermissionType;

public record ApplyPermission(Long roleId, PermissionType permissionType) {
    
}
