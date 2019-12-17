package com.creative.web.repository;

import com.creative.web.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserData,Integer> {
}
