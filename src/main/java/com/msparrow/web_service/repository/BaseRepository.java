package com.msparrow.web_service.repository;

import com.msparrow.web_service.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
}
