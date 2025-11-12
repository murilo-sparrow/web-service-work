package com.msparrow.web_service.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Caneta {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private Cores cor;
    private int tinta;
    private boolean tampada;

    @ManyToOne
    @JoinColumn(name = "estojo_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
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
