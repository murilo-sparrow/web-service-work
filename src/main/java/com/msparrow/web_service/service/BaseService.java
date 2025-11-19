package com.msparrow.web_service.service;

import com.msparrow.web_service.model.BaseEntity;
import com.msparrow.web_service.repository.BaseRepository;
import org.springframework.http.ResponseEntity;

public class BaseService<entity, id> {


    private BaseRepository<entity, id> repository;

    public BaseEntity criar() {
        final entity a = new BaseEntity();

        return repository.save(entity);
    }

    public ResponseEntity<BaseEntity> ver(Integer index) {
        return ResponseEntity.ok(repository.findById(index).orElse(null));
    }
}
