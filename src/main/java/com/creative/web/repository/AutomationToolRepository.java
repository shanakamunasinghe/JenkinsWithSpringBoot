package com.creative.web.repository;

import com.creative.web.model.AutomationToolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationToolRepository extends JpaRepository<AutomationToolData,Integer> {
}
