package com.cursoudemy.produtosapi.repository;

import com.cursoudemy.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
