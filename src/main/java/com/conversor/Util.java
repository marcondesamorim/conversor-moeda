package com.conversor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.conversor.domain.entities.Moeda;

public class Util {
    public static List<Moeda> moedas = new ArrayList<Moeda>();

    public static String jsonToString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonToString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonToString += resposta;
        }

        if (jsonToString != null) {
            jsonToString = jsonToString.substring(10, jsonToString.length() - 1);
        }

        return jsonToString;
    }

    public static List<Moeda> inicializaMoedas() {
        moedas = new ArrayList<Moeda>();

        moedas.add(new Moeda("BRL-USD", "Real para Dolar"));
        moedas.add(new Moeda("BRL-EUR", "Real para Euro"));
        moedas.add(new Moeda("BRL-GBP", "Real para Libra Esterlina"));
        moedas.add(new Moeda("BRL-ARS", "Real para Peso Argentino"));
        moedas.add(new Moeda("BRL-CLP", "Real para Peso Chileno"));
        moedas.add(new Moeda("USD-BRL", "Dolar para Real"));
        moedas.add(new Moeda("EUR-BRL", "Euro para Real"));
        moedas.add(new Moeda("GBP-BRL", "Libra Esterlina para Real"));
        moedas.add(new Moeda("ARS-BRL", "Peso Argentino para Real"));
        moedas.add(new Moeda("CLP-BRL", "Peso Chileno para Real"));

        return moedas;
    }
}
