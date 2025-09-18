package com.msparrow.web_service.caneta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanetaRepository extends JpaRepository<Caneta, Integer> {
}
