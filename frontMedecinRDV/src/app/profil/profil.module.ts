import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProfilComponent} from './profil.component';
import {ProfilMedecinComponent} from './profil-medecin/profil-medecin.component';
import {ProfilPatientComponent} from './profil-patient/profil-patient.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ProfilRoutingModule} from './profil-routing.module';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [
    ProfilComponent,
    ProfilMedecinComponent,
    ProfilPatientComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    ProfilRoutingModule,
    RouterModule
  ],
  exports: [
    ProfilComponent,
    ProfilMedecinComponent,
    ProfilPatientComponent
  ]
})
export class ProfilModule { }
