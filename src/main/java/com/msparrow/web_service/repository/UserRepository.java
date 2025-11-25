package com.msparrow.web_service.repository;

import com.msparrow.web_service.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
}
