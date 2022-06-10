package com.conversor.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Moeda {

    String codigo;
    String descricao;

    public Moeda() {
    };

    public Moeda(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
