package com.test_axa.hr.service;

import java.util.List;

import com.test_axa.hr.model.dto.ApplyPermission;
import com.test_axa.hr.model.dto.RoleDto;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    RoleDto getRoleById(Long id);
    List<RoleDto> getAllRoles();
    RoleDto updateRole(Long id, RoleDto roleDto);
    void deleteRole(Long id);

    void applyPermissionToRole(ApplyPermission request);
}

