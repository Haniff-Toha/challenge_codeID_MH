package com.test_axa.hr.service;

import java.util.List;

import com.test_axa.hr.model.dto.PermissionDto;

public interface PermissionService {
    PermissionDto createPermission(PermissionDto permissionDto);
    PermissionDto getPermissionById(Long id);
    List<PermissionDto> getAllPermissions();
    PermissionDto updatePermission(Long id, PermissionDto permissionDto);
    void deletePermission(Long id);
}

