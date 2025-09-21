package com.cursoudemy.produtosapi.controller;

import com.cursoudemy.produtosapi.model.Produto;
import com.cursoudemy.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired //funciona como um construtor que injeta a dependência
    private ProdutoRepository repository;

    //Método para salvar um produto:
    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido" + produto);

        var id = UUID.randomUUID().toString(); //declara uma variável id que receberá uma chave única que foi tranformada em String
        produto.setId(id);//antes de gravar o produto na tabela, seta o id gerado no passo anterior na entidade produto

        repository.save(produto);//grava o produto na tabela
        return  produto;

    }
}
