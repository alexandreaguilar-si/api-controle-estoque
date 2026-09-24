package com.estoque.api_controle_estoque.service;

import com.estoque.api_controle_estoque.model.Produto;
import com.estoque.api_controle_estoque.repository.ProdutoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Injeção de dependência via construtor (Boa prática no Spring Boot)
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(@NonNull Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(@NonNull Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(@NonNull Long id) {
        produtoRepository.deleteById(id);
    }
}