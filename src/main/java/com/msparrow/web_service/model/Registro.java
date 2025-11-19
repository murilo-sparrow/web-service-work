package com.msparrow.web_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Registro extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CoresType cor;

    private String texto;
    private Date writeDate;
}
