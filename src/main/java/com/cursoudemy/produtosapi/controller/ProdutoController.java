package com.cursoudemy.produtosapi.controller;

import com.cursoudemy.produtosapi.model.Produto;
import com.cursoudemy.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id){//o metodo recebe o id da entidade como parâmetro
//        Optional<Produto> produto = repository.findById(id);
//        return produto.isPresent() ? produto.get() :  null;

        return repository.findById(id).orElse(null);//retorna de repositório o produto que possui o id passado, ou null se não encontrou na base
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);//seta na entidade o id passado via parâmetro
        repository.save(produto);//atualiza os dados na tabela com base no que foi informado no corpo da requisição.
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){//trás a lista de produtos que possuem o nome passado via parm

        return repository.findByNome(nome);

    }
}
