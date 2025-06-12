package com.test_axa.hr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test_axa.hr.model.dto.PermissionDto;
import com.test_axa.hr.model.dto.RoleDto;
import com.test_axa.hr.model.entity.Permission;
import com.test_axa.hr.model.entity.Role;
import com.test_axa.hr.model.enumeration.PermissionType;
import com.test_axa.hr.repository.PermissionRepository;
import com.test_axa.hr.repository.RoleRepository;
import com.test_axa.hr.service.implementation.PermissionServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PermissionTest {
    
    @Mock
    private PermissionRepository permissionRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private PermissionServiceImpl permissionService;

    @Test
    void testCreatePermission() {
        RoleDto roleDto = new RoleDto(1L, "ADMIN");
        PermissionDto permissionDto = new PermissionDto(1L, PermissionType.READ, 1L);

        Role role = Role.builder().roleId(1L).roleName("ADMIN").build();
        Permission permission = new Permission(1L, PermissionType.READ, Role.builder().roleId(1L).roleName("ADMIN").build());

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        when(permissionRepository.save(any(Permission.class))).thenReturn(permission);

        PermissionDto saved = permissionService.createPermission(permissionDto);

        assertEquals(PermissionType.READ, saved.permissionType());
        verify(permissionRepository).save(any(Permission.class));
    }

    @Test
    void testGetPermissionById() {
        Permission permission = new Permission(1L, PermissionType.READ, Role.builder().roleId(1L).roleName("ADMIN").build());
        when(permissionRepository.findById(1L)).thenReturn(Optional.of(permission));

        PermissionDto found = permissionService.getPermissionById(1L);

        assertEquals(PermissionType.READ, found.permissionType());
        assertEquals(1L, found.permissionId());
    }
}
