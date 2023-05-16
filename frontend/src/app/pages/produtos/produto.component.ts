import { Component } from '@angular/core';
import { ProdutoService } from '../../service/produto.service';
import { Produto } from '../../model/ProdutoModel';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent {

  //Objeto do tipo Produto
  produto = new Produto();

  //Variável para visibilidade dos botões
  btnCadastro:boolean = true;

  //Variável de contagem de cadastros
  contCadastros:boolean = true

  // Variável para visibilidade da tabelaProdutos
  tabelaProdutos:boolean = true;

  //JSON de Produtos
  produtos:Produto[] = [];

  //Constructor
  constructor(private service:ProdutoService){}

  //Método de Seleção
  selecionar():void{
    this.service.selecionar()
    .subscribe(retorno => this.produtos = retorno);
  }

  //Método de Cadastro um produto
  cadastrar():void{
    this.service.cadastrar(this.produto)
    .subscribe(retorno => { 
      
      //Cadastrar o cliente no vetor
      this.produtos.push(retorno); });

      //Limpar o Formulário
      this.produto = new Produto();

      //Mensagem
      alert('Produto cadastrado com Sucesso!')

    //this.load();
  }

  //Método para editar um produto
  editar():void{

    this.service.editar(this.produto)
    .subscribe(retorno => {

      //Obter posição do vetor onde está o produto
      let posicao = this.produtos.findIndex(obj => {
        return obj.codigo == retorno.codigo;
      });

      //Alterar os dados do cliente no vetor
      this.produtos[posicao] = retorno;

       //Mensagem
       alert('Produto Alterado com Sucesso!')

      //Limpar o formulário
      this.produto = new Produto();

      //Visibilidade dos botões
      this.btnCadastro = true;

      //Visibiilidade da Tabela de Produtos
      this.tabelaProdutos = true;

      //Visibilidade da contagem
      this.contCadastros = true;
    });
  }


  //Método para editar um produto
  remover():void{

    this.service.remover(this.produto.codigo)
    .subscribe(retorno => {

      //Obter posição do vetor onde está o produto
      let posicao = this.produtos.findIndex(obj => {
        return obj.codigo == this.produto.codigo;
      });
   
      //Alterar os dados do cliente no vetor
      this.produtos.splice(posicao, 1);

       //Mensagem
       alert('Produto Excluído!')

      //Limpar o formulário
      this.produto = new Produto();

      //Visibilidade dos botões
      this.btnCadastro = true;

      //Visibiilidade da Tabela de Produtos
      this.tabelaProdutos = true;

      //Visibilidade da contagem
      this.contCadastros = true;
    });
  }

  //Método para cancelar
  cancelar():void{
    //Limpar o formulário
    this.produto = new Produto();

    //Visibilidade dos botões
    this.btnCadastro = true;

    //Visibiilidade da Tabela de Produtos
    this.tabelaProdutos = true;

    //Visibilidade da contagem
    this.contCadastros = true;
  }


  //Método para selecionar um produto específico
  selecionarProduto(posicao:number):void{

    //Selecionar produto no vetor
    this.produto = this.produtos[posicao];

    //Visibilidade dos botões
    this.btnCadastro = false;

    //Visibilidade da tabelaProdutos
    this.tabelaProdutos = false;

    //Visibilidade da contagem de cadastros
    this.contCadastros = false;

  }

  //Método para recarregar a página
  load() {
    location.reload()
  }

  //Função para confirmar exclusão
  confirmaExclusao() {
    if(confirm("Deseja realmente EXCLUIR esse cadastro?") == true){
      this.remover();
    }else{
      this.selecionar();
    }
  }

  //Método de Inicialização
 ngOnInit(){
    this.selecionar();
 }

}
