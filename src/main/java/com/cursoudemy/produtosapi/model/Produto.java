package com.cursoudemy.produtosapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//POJO -> Plain Old Java Object
@Entity
@Table(name = "produto")//opcional quando o nome da entidade é igual ao nome da tabela
public class Produto {

    @Id
    @Column(name = "id")//opcional quando a propriedade tem o mesmo nome da coluna na tabela
    private String id;
    @Column(name = "nome")//opcional quando a propriedade tem o mesmo nome da coluna na tabela
    private String nome;
    @Column(name = "descricao")//opcional quando a propriedade tem o mesmo nome da coluna na tabela
    private String descricao;
    @Column(name = "preco")//opcional quando a propriedade tem o mesmo nome da coluna na tabela
    private Double preco;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
