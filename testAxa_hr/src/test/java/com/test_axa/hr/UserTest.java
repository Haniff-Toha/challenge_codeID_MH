package com.test_axa.hr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import com.test_axa.hr.model.dto.UserDto;
import com.test_axa.hr.model.entity.Role;
import com.test_axa.hr.model.entity.User;
import com.test_axa.hr.repository.RoleRepository;
import com.test_axa.hr.repository.UserRepository;
import com.test_axa.hr.service.implementation.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        RoleDto roleDto = new RoleDto(1L, "ADMIN");
        UserDto userDto = new UserDto(1L, "testuser", "password", 1L);

        Role role = Role.builder().roleId(1L).roleName("ADMIN").build();
        User user = new User(1L, "testuser", "password", Role.builder().roleId(1L).roleName("ADMIN").build());

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDto savedUser = userService.createUser(userDto);

        assertEquals("testuser", savedUser.username());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testFindUserById() {
        Role role = Role.builder().roleId(1L).roleName("ADMIN").build();
        User user = new User(1L, "testuser", "password", role);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserDto result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals(1L, result.userId());
        assertEquals("testuser", result.username());
    }
}

