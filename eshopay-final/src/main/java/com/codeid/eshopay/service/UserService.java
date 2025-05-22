package com.codeid.eshopay.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.codeid.eshopay.model.dto.UserDto;
import com.codeid.eshopay.model.dto.UserResponseDto;

public interface UserService extends BaseCrudService<UserDto, Integer>{
    List<UserResponseDto> findAll(Pageable pageable);
    
}
