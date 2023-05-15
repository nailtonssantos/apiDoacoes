import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

import { ProdutoComponent } from './pages/produtos/produto.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './pages/home/home.component';
import { Error404Component } from './pages/error404/error404.component';
import { LoginComponent } from './pages/login/login.component';
import { FooterComponent } from './pages/footer/footer.component';
import { NavComponent } from './pages/nav/nav.component';
import { PrivacityComponent } from './pages/privacity/privacity.component';
import { TermsComponent } from './pages/terms/terms.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';


@NgModule({
  declarations: [
    AppComponent,
    ProdutoComponent,
    HomeComponent,
    Error404Component,
    LoginComponent,
    FooterComponent,
    NavComponent,
    PrivacityComponent,
    TermsComponent,
    AboutComponent,
    ContactComponent,
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
