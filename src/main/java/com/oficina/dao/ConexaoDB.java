package com.oficina.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final Dotenv DOTENV = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public static Connection conectar() throws SQLException {
        String url = obterVariavel("DB_URL");
        String user = obterVariavel("DB_USER");
        String pass = obterVariavel("DB_PASS");
        return DriverManager.getConnection(url, user, pass);
    }

    private static String obterVariavel(String nome) {
        String valor = DOTENV.get(nome, System.getenv(nome));

        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("Configure a variavel " + nome + " no arquivo .env ou no ambiente.");
        }

        return valor;
    }
}
