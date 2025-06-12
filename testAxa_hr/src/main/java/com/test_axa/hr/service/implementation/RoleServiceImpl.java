package com.test_axa.hr.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test_axa.hr.model.dto.ApplyPermission;
import com.test_axa.hr.model.dto.RoleDto;
import com.test_axa.hr.model.entity.Permission;
import com.test_axa.hr.model.entity.Role;
import com.test_axa.hr.repository.PermissionRepository;
import com.test_axa.hr.repository.RoleRepository;
import com.test_axa.hr.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public RoleDto createRole(RoleDto RoleDto) {
        Role role = new Role();
        role.setRoleName(RoleDto.roleName());
        Role saved = roleRepository.save(role);
        return new RoleDto(saved.getRoleId(), saved.getRoleName());
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + id));
        return new RoleDto(role.getRoleId(), role.getRoleName());
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> new RoleDto(role.getRoleId(), role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto updateRole(Long id, RoleDto RoleDto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        role.setRoleName(RoleDto.roleName());
        Role updated = roleRepository.save(role);
        return new RoleDto(updated.getRoleId(), updated.getRoleName());
    }

    @Override
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found");
        }
        roleRepository.deleteById(id);
    }

    @Override
    public void applyPermissionToRole(ApplyPermission request) {
        Role role = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Permission permission = new Permission();
        permission.setPermissionType(request.permissionType());
        permission.setRole(role);

        permissionRepository.save(permission);
    }
}
