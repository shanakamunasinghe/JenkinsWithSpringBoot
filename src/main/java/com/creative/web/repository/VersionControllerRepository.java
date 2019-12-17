package com.creative.web.repository;

import com.creative.web.model.VersionControllerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionControllerRepository extends JpaRepository<VersionControllerData,Integer> {
}
