package com.msparrow.web_service.dto;

import java.util.List;

import com.msparrow.web_service.model.CoresType;

import lombok.Data;

@Data
public class EstojoDto {

    public EstojoDto(Integer id, CoresType cor, List<Integer> canetas, Integer userId) {
        this.id = id;
        this.cor = cor;
        this.canetas = canetas;
        this.userId = userId;
    }

    public EstojoDto() {
    }

    private Integer id;
    private CoresType cor;
    private List<Integer> canetas;
    private Integer userId;

}
