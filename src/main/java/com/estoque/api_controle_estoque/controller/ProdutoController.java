package com.estoque.api_controle_estoque.controller;

import com.estoque.api_controle_estoque.model.Produto;
import com.estoque.api_controle_estoque.service.ProdutoService;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(
            @PathVariable @NonNull Long id) {

        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);

        if (produtoOpt.isPresent()) {
            return ResponseEntity.ok(produtoOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(
            @RequestBody @NonNull Produto produto) {

        Produto novoProduto = produtoService.salvar(produto);

        return ResponseEntity.ok(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable @NonNull Long id,
            @RequestBody @NonNull Produto produtoAtualizado) {

        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);

        if (produtoOpt.isPresent()) {
            Produto produtoExistente = produtoOpt.get();
            
            // Atualiza os campos do produto existente com os dados recebidos
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setDescricao(produtoAtualizado.getDescricao());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());

            Produto produtoAtualizadoSalvo = produtoService.salvar(produtoExistente);
            return ResponseEntity.ok(produtoAtualizadoSalvo);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable @NonNull Long id) {

        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);

        if (produtoOpt.isPresent()) {
            produtoService.deletar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}