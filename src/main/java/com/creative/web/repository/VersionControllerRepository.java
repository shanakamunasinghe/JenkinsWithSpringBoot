package com.creative.web.repository;

import com.creative.web.model.VersionControllerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionControllerRepository extends JpaRepository<VersionControllerData,Integer> {
}
