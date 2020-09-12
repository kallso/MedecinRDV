import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {RegisterModule} from './register/register.module';
import {HttpClientModule} from '@angular/common/http';
import {SearchModule} from './search/search.module';
import {HeaderModule} from './header/header.module';
import {FooterModule} from './footer/footer.module';
import { ProfilMedecinComponent } from './profil-medecin/profil-medecin.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfilMedecinComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HeaderModule,
    FooterModule,
    SearchModule,
    RegisterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
