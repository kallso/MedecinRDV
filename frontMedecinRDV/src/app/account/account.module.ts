import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AccountComponent} from './account.component';
import {AccountRoutingModule} from './account-routing.module';
import {ProfilsModule} from './profils/profils.module';
import {RendezVousModule} from './rendez-vous/rendez-vous.module';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [
    AccountComponent
  ],
  imports: [
    CommonModule,
    AccountRoutingModule,
    ProfilsModule,
    RendezVousModule,
    RouterModule
  ],
  exports: [
    AccountComponent
  ]
})
export class AccountModule { }
