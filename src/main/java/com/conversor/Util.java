package com.conversor;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
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
}
