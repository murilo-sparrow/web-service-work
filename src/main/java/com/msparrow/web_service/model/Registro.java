package com.msparrow.web_service.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Registro {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    public Registro(CoresType cor, String texto, Date writeDate) {
        this.cor = cor;
        this.texto = texto;
        this.writeDate = writeDate;
    }

    public Registro() {

    }

    private CoresType cor;
    private String texto;
    private Date writeDate;
}
