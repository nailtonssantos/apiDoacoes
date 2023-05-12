import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProdutoComponent } from './principal/produto.component';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { Error404Component } from './pages/error404/error404.component';
import { LoginComponent } from './pages/login/login.component';


const routes: Routes = [
  { path: 'produtos', component: ProdutoComponent },
  { path: 'home', component: HomeComponent },
  { path: 'about/:id', component: AboutComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {
    path: '**', component: Error404Component
  },
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }
