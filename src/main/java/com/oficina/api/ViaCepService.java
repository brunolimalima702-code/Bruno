package com.oficina.api;

import com.google.gson.Gson;
import com.oficina.model.Cliente;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepService {
    public static Cliente buscarEnderecoPorCep(String cep) throws Exception {
        String cepLimpo = cep == null ? "" : cep.replaceAll("\\D", "");

        if (cepLimpo.length() != 8) {
            throw new IllegalArgumentException("CEP invalido. Informe 8 numeros.");
        }

        String url = "https://viacep.com.br/ws/" + cepLimpo + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("nao foi possivel consultar o ViaCEP.");
        }

        if (response.body().contains("\"erro\": true")) {
            throw new Exception("CEP nao encontrado.");
        }

        Gson gson = new Gson();
        return gson.fromJson(response.body(), Cliente.class);
    }
}
