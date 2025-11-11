package com.msparrow.web_service.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Estojo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private ArrayList<Caneta> canetas = new ArrayList<>();
    private String dono;

}
