import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormMedecinComponent} from './form-medecin/form-medecin.component';
import {RegisterComponent} from './register.component';
import {FormPatientComponent} from './form-patient/form-patient.component';

const routes: Routes = [
  {
    path: '',
    component: RegisterComponent,
    children: [
      {
        path: 'form-medecin',
        component: FormMedecinComponent
      },
      {
        path: 'form-patient',
        component: FormPatientComponent
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegisterRoutingModule { }
