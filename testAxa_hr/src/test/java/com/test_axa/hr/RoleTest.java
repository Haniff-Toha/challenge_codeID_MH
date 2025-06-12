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

import com.test_axa.hr.model.dto.RoleDto;
import com.test_axa.hr.model.entity.Role;
import com.test_axa.hr.repository.RoleRepository;
import com.test_axa.hr.service.implementation.RoleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RoleTest {
    
    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    @Test
    void testCreateRole() {
        RoleDto roleDto = new RoleDto(1L, "ADMIN");
        Role role = Role.builder().roleId(1L).roleName("ADMIN").build();

        when(roleRepository.save(any(Role.class))).thenReturn(role);

        RoleDto saved = roleService.createRole(roleDto);

        assertEquals("ADMIN", saved.roleName());
        verify(roleRepository).save(any(Role.class));
    }

    @Test
    void testGetRoleById() {
        Role role = Role.builder().roleId(1L).roleName("ADMIN").build();
        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        RoleDto found = roleService.getRoleById(1L);

        assertEquals(1L, found.roleId());
        assertEquals("ADMIN", found.roleName());
    }
}
