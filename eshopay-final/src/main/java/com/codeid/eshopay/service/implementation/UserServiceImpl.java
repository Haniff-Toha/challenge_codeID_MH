package com.codeid.eshopay.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codeid.eshopay.model.dto.UserDto;
import com.codeid.eshopay.model.dto.UserResponseDto;
import com.codeid.eshopay.model.entity.Location;
import com.codeid.eshopay.model.entity.User;
import com.codeid.eshopay.repository.UserRepository;
import com.codeid.eshopay.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public static UserResponseDto mapToDtoResponse(User user){
        return new UserResponseDto(
            user.getUserId(),
            user.getUserName()
        );
    }

    public static UserDto mapToDto(User user){
        return new UserDto(
            user.getUserId(),
            user.getUserName(),
            user.getUserEmail(),
            user.getUserPassword(),
            user.getUserHandphone(),
            user.getLocation().getLocationId());
    }

    public static User mapToEntity(UserDto userDto){
        return User.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .userEmail(userDto.getUserEmail())
                .userHandphone(userDto.getUserHandphone())
                .userPassword(userDto.getUserPassword())
                .location(Location.builder().locationId(userDto.getLocationId()).build())
                .build();
    }
    
    @Override
    public List<UserDto> findAll() {
        log.debug("Request to get all user as admin");
        return this.userRepository.findAll().stream()
                .map(UserServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        log.debug("Admin Request to get User : {}", id);
        return this.userRepository.findById(id).map(UserServiceImpl::mapToDto)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    @Override
    public UserDto save(UserDto entity) {
       log.debug("Request to create User : {}", entity);

        var user = mapToEntity(entity);

        // after save, langsung ubah ke dto
        return mapToDto(this.userRepository.save(user));
    }

    @Override
    public UserDto update(Integer id, UserDto entity) {
        log.debug("Request to update user : {}", id);
        var user = this.userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found with id " + id));
        
        user.setUserName(entity.getUserName());
        user.setUserEmail(entity.getUserEmail());
        user.setUserHandphone(entity.getUserHandphone());
        user.setUserPassword(entity.getUserPassword());
        user.setLocation(Location.builder().locationId(entity.getLocationId()).build());

        this.userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete user : {}", id);

        var user = this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

        this.userRepository.deleteById(user.getUserId());
    }

    @Override
    public List<UserResponseDto> findAll(Pageable pageable) {
        log.debug("Request to get all User");
        return this.userRepository.findAll(pageable)
            .stream().map(UserServiceImpl::mapToDtoResponse).toList();
    }
    
}
