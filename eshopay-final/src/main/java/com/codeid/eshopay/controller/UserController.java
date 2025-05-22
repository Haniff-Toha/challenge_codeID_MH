package com.codeid.eshopay.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeid.eshopay.model.dto.UserDto;
import com.codeid.eshopay.service.BaseCrudService;
import com.codeid.eshopay.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user/admin/")
public class UserController extends BaseCrudController<UserDto, Integer>{
    private final UserService userService;

    @Override
    protected BaseCrudService<UserDto, Integer> getService() {
       return userService;
    }

    @Override
    public ResponseEntity<UserDto> create(@Valid UserDto entity) {
        return super.create(entity);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<UserDto> getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<UserDto> update(Integer id, @Valid UserDto entity) {
        return super.update(id, entity);
    }

    
    
}
