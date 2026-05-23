package com.oficina.model;

public class OrdemServico {
    private int id;
    private String descricao;
    private double valor;
    private int clienteId;

    public OrdemServico() {}

    public OrdemServico(String descricao, double valor, int clienteId) {
        this.descricao = descricao;
        this.valor = valor;
        this.clienteId = clienteId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    @Override
    public String toString() {
        return "OS ID: " + id + " | Descricao: " + descricao + " | Valor: R$" + valor + " | Cliente ID: " + clienteId;
    }
}
