package com.codeid.eshopper.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeid.eshopper.entities.Department;
import com.codeid.eshopper.repository.DepartmentRepository;
import com.codeid.eshopper.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }



    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }



    @Override
    public Department addDepartment(Department dept) {
        return departmentRepository.save(dept);
    }



    @Override
    public Optional<Department> findDepartmentById(Integer departmentId) {
        return departmentRepository.findById(departmentId);
    }



    @Override
    public void deleteDepartmentById(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }
    
}
