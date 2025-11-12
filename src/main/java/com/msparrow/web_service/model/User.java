package com.msparrow.web_service.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "estojo_id")
    private Estojo estojo;
    private String nome;

}
