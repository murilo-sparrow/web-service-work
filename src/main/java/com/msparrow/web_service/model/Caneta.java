package com.msparrow.web_service.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Caneta extends BaseEntity {

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
