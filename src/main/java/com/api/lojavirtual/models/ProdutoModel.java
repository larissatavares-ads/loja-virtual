package com.api.lojavirtual.models;

public class ProdutoModel {
    private int Id;
    private String Nome;
    private String Descricao;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Descricao='" + Descricao + '\'' +
                '}';
    }
}
