package com.msparrow.web_service.dto;

import com.msparrow.web_service.model.CoresType;

import lombok.Data;

@Data
public class CanetaDto {

    public CanetaDto(Integer id, CoresType cor, int tinta, boolean tampada, Integer estojoId) {
        this.id = id;
        this.cor = cor;
        this.tinta = tinta;
        this.tampada = tampada;
        this.estojoId = estojoId;
    }

    public CanetaDto() {
    }

    private Integer id;
    private CoresType cor;
    private int tinta;
    private boolean tampada;
    private Integer estojoId;

}
