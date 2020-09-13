import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RendezVousPatientComponent} from './rendez-vous-patient/rendez-vous-patient.component';
import {RendezVousMedecinComponent} from './rendez-vous-medecin/rendez-vous-medecin.component';


@NgModule({
  declarations: [
    RendezVousPatientComponent,
    RendezVousMedecinComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    RendezVousPatientComponent,
    RendezVousMedecinComponent
  ]
})
export class RendezVousModule { }
