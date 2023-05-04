package br.com.api.doacoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.doacoes.model.Mensagem;
import br.com.api.doacoes.model.ProdutoModel;
import br.com.api.doacoes.repository.ProdutoRepository;


@Service
public class ProdutoServices {
    
    @Autowired
    private Mensagem mensagem;
    
    @Autowired
    private ProdutoRepository acao;

    //Método para Cadastrar Produtos
    public ResponseEntity<?> cadastrarProduto(ProdutoModel obj){
        if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getNome().length() > 20){
            mensagem.setMensagem("Nome do Produto Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getMedida().equals("")){
            mensagem.setMensagem("A Medida precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getMedida().length() > 2){
            mensagem.setMensagem("Sigla da Medida de Produto Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getFormaEntrega().equals("")){
            mensagem.setMensagem("A Forma de Entrega precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getFormaEntrega().length() > 10){
            mensagem.setMensagem("A Forma de Entrega é Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getTipo().equals("")){
            mensagem.setMensagem("O tipo precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getTipo().length() > 20){
            mensagem.setMensagem("Tipo de Produto Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            acao.save(obj);
            mensagem.setMensagem("Produto Cadastrado com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }
    }

    /*
     * Método para listar todos os produtos
    */
    public ResponseEntity<?> listarProdutos(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    /*
     * Método para filtrar um produto pelo Código
    */
    public ResponseEntity<?> filtrarProdutoPorCodigo(long codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }
    }

    /*
     * Método para Editar um produto
    */
    public ResponseEntity<?> editarProduto(ProdutoModel obj){
        if(acao.countByCodigo(obj.getCodigo()) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getNome().length() > 20){
            mensagem.setMensagem("Nome do Produto Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getMedida().equals("")){
            mensagem.setMensagem("A Medida precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getMedida().length() > 2){
            mensagem.setMensagem("Sigla da Medida de Produto Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getFormaEntrega().equals("")){
            mensagem.setMensagem("A Forma de Entrega precisa ser preenchida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getFormaEntrega().length() > 10){
            mensagem.setMensagem("A Forma de Entrega é Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getTipo().equals("")){
            mensagem.setMensagem("O tipo precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getTipo().length() > 20){
            mensagem.setMensagem("Tipo de Produto Muito Grande");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            acao.save(obj);
            mensagem.setMensagem("Produto Editado com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }
    }

     /*
     * Método para Remover um produto
    */
    public ResponseEntity<?> removerProduto(int codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O Produto informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            ProdutoModel obj = acao.findByCodigo(codigo);
            acao.delete(obj);

            mensagem.setMensagem("Produto Removido com Sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> inativarProduto(int codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O Produto informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            ProdutoModel produto = acao.findByCodigo(codigo);
            produto.setAtivo(false);

            mensagem.setMensagem("Produto Inativado com Sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
