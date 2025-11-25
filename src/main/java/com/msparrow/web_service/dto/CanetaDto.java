package com.msparrow.web_service.dto;

import com.msparrow.web_service.model.CoresType;
import lombok.Data;

import java.util.Date;

@Data
public class CanetaDto extends BaseDto {

    public CanetaDto(Integer id, Date createdDate, Date modifiedDate,
                     CoresType cor, int tinta, boolean tampada, Integer estojoId) {
        super(id, createdDate, modifiedDate);
        this.cor = cor;
        this.tinta = tinta;
        this.tampada = tampada;
        this.estojoId = estojoId;
    }

    public CanetaDto(Integer id, Date createdDate, Date modifiedDate) {
        super(id, createdDate, modifiedDate);
    }

    private CoresType cor;
    private int tinta;
    private boolean tampada;
    private Integer estojoId;

}
