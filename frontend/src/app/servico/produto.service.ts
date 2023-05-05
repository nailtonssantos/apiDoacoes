import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Produto } from '../model/ProdutoModel';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  //Url da Api
  private url:string = 'http://localhost:8090';

  constructor(private http:HttpClient) { }

  //Método para selecionar todos os clientes
  selecionar():Observable<Produto[]>{
    return this.http.get<Produto[]>(this.url)
  }
}
