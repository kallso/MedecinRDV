import {NgModule} from '@angular/core';
import {RegisterRoutingModule} from './register-routing.module';
import {RegisterComponent} from './register.component';
import {FormMedecinComponent} from './form-medecin/form-medecin.component';
import {FormPatientComponent} from './form-patient/form-patient.component';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    RegisterComponent,
    FormMedecinComponent,
    FormPatientComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RegisterRoutingModule,
  ],
  exports: [
    RegisterComponent,
    FormMedecinComponent,
    FormPatientComponent
  ]
})
export class RegisterModule { }
