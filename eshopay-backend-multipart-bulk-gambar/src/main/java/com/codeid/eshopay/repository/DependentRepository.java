package com.codeid.eshopay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeid.eshopay.model.entity.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Integer>{
    //jpql, basedn on object
    @Query(value="SELECT d from Dependent d where d.employee.employeeId=:id")
    List<Dependent> findDependentByEmplooyeeIdJpql(@Param("id") Integer id);

    //nativesql
    @Query(value="SELECT * FROM hr.dependents d where d.employee_id=:id",nativeQuery = true)
    List<Dependent> findDependentByEmplooyeeIdSql(@Param("id") Integer id);
}
