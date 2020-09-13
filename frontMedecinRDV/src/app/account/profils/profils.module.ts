import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProfilPatientComponent} from './profil-patient/profil-patient.component';
import {ProfilMedecinComponent} from './profil-medecin/profil-medecin.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    ProfilPatientComponent,
    ProfilMedecinComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    ProfilPatientComponent,
    ProfilMedecinComponent
  ]
})
export class ProfilsModule { }
