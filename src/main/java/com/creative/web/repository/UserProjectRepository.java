package com.creative.web.repository;

import com.creative.web.model.UsersProjectsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<UsersProjectsData,Integer> {

}
