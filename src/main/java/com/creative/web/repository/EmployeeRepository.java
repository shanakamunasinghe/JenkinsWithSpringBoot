package com.creative.web.repository;

import com.creative.web.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData,Integer> {

    public EmployeeData findByName(String name);
}
