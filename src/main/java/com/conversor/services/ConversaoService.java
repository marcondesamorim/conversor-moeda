package com.conversor.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.conversor.domain.entities.Conversao;
import com.conversor.exceptions.NotFoundException;

@Service
public class ConversaoService {

    private final List<Conversao> conversoes = new ArrayList<Conversao>();

    public Conversao getCotacao(Integer id) {
        return this.conversoes.stream().filter(cotacao -> cotacao.getId() == id).findAny()
                .orElseThrow(NotFoundException::new);
    }

    public Conversao createConversao(Conversao conversao) {
        conversao.setId(getMaxId(this.conversoes) + 1);
        this.conversoes.add(conversao);
        return conversao;
    }

    public List<Conversao> getConversoes() {
        return this.conversoes;
    }

    public Conversao updateConversoes(Integer id, Conversao request) {
        Conversao conversao = this.conversoes.stream().filter(elemento -> elemento.getId() == id).findAny()
                .orElseThrow(NotFoundException::new);

        conversao.setId(id);
        conversao.setCodigo(request.getCodigo());
        conversao.setOriginal(request.getOriginal());
        conversao.setConvertido(request.getConvertido());

        return conversao;
    }

    private Integer getMaxId(List<Conversao> conversoes) {
        int id = 0;
        if (conversoes.isEmpty()) {
            return id;
        }
        List<Integer> ids = conversoes.stream().map(Conversao::getId).collect(Collectors.toList());
        id = Collections.max(ids);

        return id;
    }
}
