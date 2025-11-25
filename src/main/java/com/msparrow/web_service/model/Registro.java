package com.msparrow.web_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
public class Registro extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CoresType cor;
    private String texto;
}
