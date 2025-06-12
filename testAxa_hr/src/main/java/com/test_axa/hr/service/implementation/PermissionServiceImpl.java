package com.test_axa.hr.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test_axa.hr.model.dto.PermissionDto;
import com.test_axa.hr.model.entity.Permission;
import com.test_axa.hr.model.entity.Role;
import com.test_axa.hr.repository.PermissionRepository;
import com.test_axa.hr.repository.RoleRepository;
import com.test_axa.hr.service.PermissionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    @Override
    public PermissionDto createPermission(PermissionDto PermissionDto) {
        Role role = roleRepository.findById(PermissionDto.roleId())
            .orElseThrow(() -> new RuntimeException("Role not found with ID: " + PermissionDto.roleId()));

        Permission permission = new Permission();
        permission.setPermissionType(PermissionDto.permissionType());
        permission.setRole(role);

        Permission saved = permissionRepository.save(permission);
        return new PermissionDto(saved.getPermissionId(), saved.getPermissionType(), saved.getRole().getRoleId());
    }

    @Override
    public PermissionDto getPermissionById(Long id) {
        Permission permission = permissionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Permission not found"));
        return new PermissionDto(permission.getPermissionId(), permission.getPermissionType(), permission.getRole().getRoleId());
    }

    @Override
    public List<PermissionDto> getAllPermissions() {
        return permissionRepository.findAll().stream()
            .map(p -> new PermissionDto(p.getPermissionId(), p.getPermissionType(), p.getRole().getRoleId()))
            .collect(Collectors.toList());
    }

    @Override
    public PermissionDto updatePermission(Long id, PermissionDto dto) {
        Permission permission = permissionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Permission not found"));
        
        Role role = roleRepository.findById(dto.roleId())
            .orElseThrow(() -> new RuntimeException("Role not found"));

        permission.setPermissionType(dto.permissionType());
        permission.setRole(role);

        Permission updated = permissionRepository.save(permission);
        return new PermissionDto(updated.getPermissionId(), updated.getPermissionType(), updated.getRole().getRoleId());
    }

    @Override
    public void deletePermission(Long id) {
        if (!permissionRepository.existsById(id)) {
            throw new RuntimeException("Permission not found");
        }
        permissionRepository.deleteById(id);
    }
}

