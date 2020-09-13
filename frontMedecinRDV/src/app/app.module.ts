import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {RegisterModule} from './register/register.module';
import {HttpClientModule} from '@angular/common/http';
import {SearchModule} from './search/search.module';
import {HeaderModule} from './header/header.module';
import {FooterModule} from './footer/footer.module';
import {AccountModule} from './account/account.module';
import {LoginModule} from './login/login.module';
import {NotFoundModule} from './not-found/not-found.module';

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
    AccountModule,
    LoginModule,
    NotFoundModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
