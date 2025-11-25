package com.msparrow.web_service.dto;

import com.msparrow.web_service.model.CoresType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EstojoDto extends BaseDto {

    public EstojoDto(Integer id, Date createdDate, Date modifiedDate, CoresType cor, List<Integer> canetas, Integer userId) {
        super(id, createdDate, modifiedDate);
        this.cor = cor;
        this.canetas = canetas;
        this.userId = userId;
    }

    public EstojoDto(Integer id, Date createdDate, Date modifiedDate) {
        super(id, createdDate, modifiedDate);
    }

    private CoresType cor;
    private List<Integer> canetas;
    private Integer userId;

}
