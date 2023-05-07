package br.com.api.doacoes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.doacoes.model.Mensagem;
import br.com.api.doacoes.model.ProdutoModel;
import br.com.api.doacoes.repository.ProdutoRepository;
import br.com.api.doacoes.services.ProdutoServices;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")

public class ProdutoControler {

    // ***** Disponibilizar um objeto do tipo Mensagem
    @Autowired
    private Mensagem mensagem;
    
    @Autowired
    private ProdutoRepository acao;

    @Autowired
    private ProdutoServices services;

    @PostMapping("/produtos")
    public ResponseEntity<?> cadastrarProdutos(@Valid @RequestBody ProdutoModel produto){
        acao.save(produto);
        mensagem.setMensagem("Produto Cadastrado com sucesso!");
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @PutMapping("/produtos")
    public ResponseEntity<?> alterarProdutos(@Valid @RequestBody ProdutoModel produto){
        acao.save(produto);
        mensagem.setMensagem("Produto Alterado com sucesso!");
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @DeleteMapping("/produtos/{codigo}")
    public ResponseEntity<?> removerProduto(@PathVariable int codigo){
       return services.removerProduto(codigo);
    }

    //Tem que arrumar
    @PutMapping("/produtos/{codigo}")
    public ResponseEntity<?> inativarProduto(@PathVariable int codigo){
       return services.inativarProduto(codigo);
    }

    @GetMapping("/produtos")
    public ResponseEntity<?> listarProdutos(){
        return services.listarProdutos();
    }

    @GetMapping("/produtos/{codigo}")
    public ResponseEntity<?> filtrarProdutoPorCodigo(@PathVariable int codigo){
        return services.filtrarProdutoPorCodigo(codigo);
    }

    @GetMapping("/produtos/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("/produtos/filtranomes")
    public List<ProdutoModel> filtraNome(){
        return acao.findByOrderByNome();
    }

    @GetMapping("/produtos/filtranomesdesc")
    public List<ProdutoModel> filtraNomesDesc(){
        return acao.findByOrderByNomeDesc();
    }

    @GetMapping("/produtos/filtranomesportipo/{tipo}")
    public List<ProdutoModel> filtraNomesPorTipo(@PathVariable String tipo){
        return acao.findByTipoOrderByCodigo(tipo);
    }

    @GetMapping("/produtos/filtraporparteproduto/{parteNome}")
    public List<ProdutoModel> filtraPorParteProduto(@PathVariable String parteNome){
        return acao.findByNomeContaining(parteNome);
    }

    @GetMapping("/produtos/filtraporinicial/{inicioNome}")
    public List<ProdutoModel> filtraProdutoPorInicial(@PathVariable String inicioNome){
        return acao.findByNomeStartsWith(inicioNome);
    }

    @GetMapping("/produtos/filtrarporfinalproduto/{finalProduto}")
    public List<ProdutoModel> filtraPorFinalProduto(@PathVariable String finalProduto){
        return acao.findByNomeEndsWith(finalProduto);
    }
 
    @GetMapping("/produtos/somaquantidades")
    public int somaQuantidades(){
        return acao.somaQuantidades();
    }

    @GetMapping("")
    public String mensagem(){
        return "Sistema de Doações - Desenvolvido por Nailton Silva";
    }

}