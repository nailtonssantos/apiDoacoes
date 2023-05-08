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
    .subscribe(retorno => { this.produtos.push(retorno); });
    this.load();
  }

  load() {
    location.reload()
  }

  //Método de Inicialização
 ngOnInit(){
    this.selecionar();
 }

}
