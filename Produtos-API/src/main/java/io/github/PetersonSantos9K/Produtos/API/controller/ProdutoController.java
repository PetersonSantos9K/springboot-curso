package io.github.PetersonSantos9K.Produtos.API.controller;

import io.github.PetersonSantos9K.Produtos.API.model.Produto;
import io.github.PetersonSantos9K.Produtos.API.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.repository = produtoRepository;
    }


    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        repository.save(produto);
        IO.println("Produto recebido: " + produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar (@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        repository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return repository.findByNome(nome);
    }


}
