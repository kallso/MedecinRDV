import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfilComponent} from './profil.component';
import {ProfilMedecinComponent} from './profil-medecin/profil-medecin.component';
import {ProfilPatientComponent} from './profil-patient/profil-patient.component';

const routes: Routes = [
  {
    path: '',
    component: ProfilComponent,
    children: [
      {
        path: 'medecin/:id',
        component: ProfilMedecinComponent
      },
      {
        path: 'patient/:id',
        component: ProfilPatientComponent
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfilRoutingModule { }
