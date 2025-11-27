package com.msparrow.web_service.service;

import com.msparrow.web_service.dto.BaseDto;
import com.msparrow.web_service.model.BaseEntity;
import com.msparrow.web_service.repository.BaseRepository;

public abstract class BaseService<T extends BaseEntity, D extends BaseDto> {

    final BaseRepository<T, Integer> repository;

    public BaseService(BaseRepository<T, Integer> repository) {
        this.repository = repository;
    }

    abstract T preCriar(T obj);

    public T criar(T obj) {
        obj = preCriar(obj);
        return repository.save(obj);
    }

    public D ver(Integer index) {
        T entity = repository.findById(index).orElse(null);
        if (entity == null) return null;
        return addDto(entity);
    }

    abstract D addDto(T obj);

    public void excluir(Integer index) {
        repository.deleteById(index);
    }

}
