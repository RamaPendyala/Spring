package com.sathya.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sathya.rest.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    // You can add custom query methods if needed
}
