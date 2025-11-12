package com.msparrow.web_service.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {

    public UserDto(Integer id, String nome, List<Integer> estojos) {
        this.id = id;
        this.nome = nome;
        this.estojos = estojos;
    }

    public UserDto() {
    }

    private Integer id;
    private String nome;
    private List<Integer> estojos;

}
