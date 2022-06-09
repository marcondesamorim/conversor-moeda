package com.conversor.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conversao {
    Integer id;
    Opcao opcao;
    Double original;
    Double convertido;

    public Conversao() {
    }

    public Conversao(int id, Opcao opcao, Double original, Double convertido) {
        this.id = id;
        this.opcao = opcao;
        this.original = original;
        this.convertido = convertido;
    }

    @Override
    public String toString() {
        return "Cotacao{" + "id=" + id + ", opcao=" + opcao + ", original=" + original + ", convertido=" + convertido
                + "}";
    }

}