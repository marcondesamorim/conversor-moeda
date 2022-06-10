package com.conversor.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.conversor.Util;
import com.conversor.domain.entities.Cotacao;
import com.google.gson.Gson;

@Service
public class CotacaoAPIService {
    String webService = "https://economia.awesomeapi.com.br/last/";
    int codigoSucesso = 200;

    public Cotacao pegaCotacao(String moeda) throws Exception {
        String urlString = webService + moeda;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonToString = Util.jsonToString(resposta);

            Gson gson = new Gson();
            Cotacao cotacao = gson.fromJson(jsonToString, Cotacao.class);

            return cotacao;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}