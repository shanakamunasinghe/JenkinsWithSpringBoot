package com.creative.web.repository;

import com.creative.web.model.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData,Integer> {
}
