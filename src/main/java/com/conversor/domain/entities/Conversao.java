package com.conversor.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conversao {
    Integer id;
    String codigo;
    String original;
    String convertido;

    public Conversao() {
    }

    public Conversao(int id, String codigo, String original, String convertido) {
        this.id = id;
        this.codigo = codigo;
        this.original = original;
        this.convertido = convertido;
    }

    @Override
    public String toString() {
        return "Cotacao{" + "id=" + id + ", codigo=" + codigo + ", original=" + original + ", convertido=" + convertido
                + "}";
    }

}