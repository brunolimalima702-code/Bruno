# Sistema de Oficina Mecanica (CRUD + ViaCEP)

Projeto Java utilizando JDBC para persistencia de dados e consumo da API externa ViaCEP, cumprindo os requisitos de CRUD de duas entidades relacionadas: Cliente e Ordem de Servico.

## Tecnologias e Dependencias

- Java 17+
- Maven
- MySQL Connector J 8.3.0
- Dotenv-java 3.0.0
- Gson 2.10.1

## Como rodar o projeto

1. Execute o script `script.sql` no MySQL para criar o banco `oficina_db` e as tabelas necessarias.
2. Crie um arquivo `.env` na raiz do projeto usando o `.env.example` como modelo.
3. Preencha suas credenciais do MySQL no `.env`.
4. Compile o projeto com:

```bash
mvn clean package
```

5. Execute a aplicacao com:

```bash
mvn exec:java
```

Ao cadastrar um cliente, informe o CEP e o sistema buscara automaticamente o endereco na API ViaCEP.
