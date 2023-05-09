import { Component } from '@angular/core';
import { ProdutoService } from '../servico/produto.service';
import { Produto } from '../model/ProdutoModel';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

  //Objeto do tipo Produto
  produto = new Produto();

  //Variável para visibilidade dos botões
  btnCadastro:boolean = true;

  //Variável de contagem de cadastros
  contCadastros:boolean = true

  // Variável para visibilidade da tabela
  tabela:boolean = true;

  //JSON de Produtos
  produtos:Produto[] = [];

  //Constructor
  constructor(private service:ProdutoService){}

  //Método de Seleção
  selecionar():void{
    this.service.selecionar()
    .subscribe(retorno => this.produtos = retorno);
  }

  //Método de Cadastro
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

  //Método para selecionar um produto específico
  selecionarProduto(codProduto:number):void{

    //Selecionar produto no vetor
    this.produto = this.produtos[codProduto];

    //Visibilidade dos botões
    this.btnCadastro = false;

    //Visibilidade da tabela
    this.tabela = false;

    //Visibilidade da contagem de cadastros
    this.contCadastros = false;

  }

  //Método para recarregar a página
  load() {
    location.reload()
  }

  //Método de Inicialização
 ngOnInit(){
    this.selecionar();
 }

}
