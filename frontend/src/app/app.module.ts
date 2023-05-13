import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

import { ProdutoComponent } from './pages/produtos/produto.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { Error404Component } from './pages/error404/error404.component';
import { LoginComponent } from './pages/login/login.component';
import { FooterComponent } from './pages/footer/footer.component';
import { HeaderComponent } from './pages/header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    ProdutoComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    LoginComponent,
    FooterComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
