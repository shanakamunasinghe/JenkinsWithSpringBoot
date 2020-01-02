package com.creative.web.repository;

import com.creative.web.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeData,Integer> {
}
