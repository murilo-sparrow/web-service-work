package com.msparrow.web_service.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Caneta {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CoresType cor;
    private int tinta;
    private boolean tampada;

    @ManyToOne
    @JoinColumn(name = "estojo_id")
    private Estojo estojo;

    public String escrever(String texto) {
        if (tampada) {
            return "Caneta Tampada";
        }
        int caracteres = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') {
                caracteres++;
            }
        }

        if (tinta < caracteres) {
            return "Sem tinta suficiente";
        }

        tinta -= caracteres;
        return texto;
    }

}
