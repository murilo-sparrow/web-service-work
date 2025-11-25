package com.msparrow.web_service.repository;

import com.msparrow.web_service.model.Caneta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanetaRepository extends BaseRepository<Caneta, Integer> {
}
