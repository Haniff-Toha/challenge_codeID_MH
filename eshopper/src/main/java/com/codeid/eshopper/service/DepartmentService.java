package com.codeid.eshopper.service;

import java.util.List;
import java.util.Optional;

import com.codeid.eshopper.entities.Department;

public interface DepartmentService {
    List<Department> findAllDepartments();

    Department addDepartment(Department dept);

    Optional<Department> findDepartmentById(Integer departmentId);

    void deleteDepartmentById(Integer departmentId);
}
