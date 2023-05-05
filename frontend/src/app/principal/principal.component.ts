import { Component } from '@angular/core';
import { ProdutoService } from '../servico/produto.service';
import { Produto } from '../model/ProdutoModel';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

  //Variável para visibilidade dos botões
  btnCadastro:boolean = true;

  //JSON de Produtos
  produtos:Produto[] = [];

  //Constructor
  constructor(private servico:ProdutoService){}

  //Método de Seleção
  selecionar():void{
    this.servico.selecionar().subscribe(retorno => this.produtos = retorno);
  }

  //Método de Inicialização
  //ngOnInit(){//Nativo so Angular
   // this.servico.selecionar();
 // }

 ngOnInit(){
    this.selecionar();
 }

}
