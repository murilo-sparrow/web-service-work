package com.msparrow.web_service.oo;

public class Caneta {

    private Integer id;

    private final Cores cor;
    private int tinta = 100;
    private boolean tampada = true;

    public Caneta(Cores cor) {
        this.cor = cor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTinta() {
        return tinta;
    }

    public Cores getCor() {
        return cor;
    }

    public boolean isTampada() {
        return tampada;
    }

    public void setTampada() {
        tampada = !tampada;
    }

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
