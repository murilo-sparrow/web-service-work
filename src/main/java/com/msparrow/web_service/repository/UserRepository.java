package com.msparrow.web_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msparrow.web_service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
