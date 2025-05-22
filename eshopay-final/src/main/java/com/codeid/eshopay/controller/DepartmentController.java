package com.codeid.eshopay.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeid.eshopay.model.dto.DepartmentDto;
import com.codeid.eshopay.service.BaseCrudService;
import com.codeid.eshopay.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department/")
@Tag(name = "Department", description = "Endpoints for departmetns")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController extends BaseCrudController<DepartmentDto, Integer> {

    private final DepartmentService departmentService;

    @Override
    protected BaseCrudService<DepartmentDto, Integer> getService() {
        return departmentService;
    }

    @Override
    public ResponseEntity<DepartmentDto> create(@Valid DepartmentDto entity) {
        return super.create(entity);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return super.delete(id);
    }

    @Operation(summary = "Get All Department", description = "Fecth all departmetns")
    @Override
    public ResponseEntity<List<DepartmentDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<DepartmentDto> getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<DepartmentDto> update(Integer id, @Valid DepartmentDto entity) {
        return super.update(id, entity);
    }
    
    
    
}
