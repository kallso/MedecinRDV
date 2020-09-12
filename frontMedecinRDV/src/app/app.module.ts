import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {RegisterModule} from './register/register.module';
import {HttpClientModule} from '@angular/common/http';
import {SearchModule} from './search/search.module';
import {HeaderModule} from './header/header.module';
import {FooterModule} from './footer/footer.module';
import {ProfilModule} from './profil/profil.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HeaderModule,
    FooterModule,
    SearchModule,
    RegisterModule,
    ProfilModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
