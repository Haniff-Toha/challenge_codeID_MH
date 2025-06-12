package com.test_axa.hr.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test_axa.hr.model.dto.UserDto;
import com.test_axa.hr.model.entity.Role;
import com.test_axa.hr.model.entity.User;
import com.test_axa.hr.repository.RoleRepository;
import com.test_axa.hr.repository.UserRepository;
import com.test_axa.hr.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDto createUser(UserDto dto) {
        Role role = roleRepository.findById(dto.roleId())
            .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        user.setRole(role);

        User saved = userRepository.save(user);
        return mapToDTO(saved);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(dto.username());
        user.setPassword(dto.password());

        Role role = roleRepository.findById(dto.roleId())
            .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);

        User updated = userRepository.save(user);
        return mapToDTO(updated);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Mapping Entity -> DTO
    private UserDto mapToDTO(User user) {
        return new UserDto(
            user.getUserId(),
            user.getUsername(),
            user.getPassword(),
            user.getRole().getRoleId()
        );
    }
}

