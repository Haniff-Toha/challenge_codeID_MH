package com.test_axa.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test_axa.hr.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
