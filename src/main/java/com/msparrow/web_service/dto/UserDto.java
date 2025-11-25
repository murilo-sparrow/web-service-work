package com.msparrow.web_service.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto extends BaseDto {

    public UserDto(Integer id, Date createdDate, Date modifiedDate, String nome, List<Integer> estojos) {
        super(id, createdDate, modifiedDate);
        this.nome = nome;
        this.estojos = estojos;
    }

    public UserDto(Integer id, Date createdDate, Date modifiedDate) {
        super(id, createdDate, modifiedDate);
    }

    private String nome;
    private List<Integer> estojos;

}
