package com.msparrow.web_service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {

    BaseDto(Integer id, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    BaseDto(){}

    private Integer id;
    private Date createdDate;
    private Date modifiedDate;
}
