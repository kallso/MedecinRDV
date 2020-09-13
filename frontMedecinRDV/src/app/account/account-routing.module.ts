import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccountComponent} from './account.component';
import {ProfilMedecinComponent} from './profils/profil-medecin/profil-medecin.component';
import {ProfilPatientComponent} from './profils/profil-patient/profil-patient.component';
import {RendezVousMedecinComponent} from './rendez-vous/rendez-vous-medecin/rendez-vous-medecin.component';
import {RendezVousPatientComponent} from './rendez-vous/rendez-vous-patient/rendez-vous-patient.component';

const routes: Routes = [
  {
    path: '',
    component: AccountComponent,
    children: [
      {
        path: 'profil/medecin/:id',
        component: ProfilMedecinComponent
      },
      {
        path: 'profil/patient/:id',
        component: ProfilPatientComponent
      },
      {
        path: 'rendez-vous/medecin/:id',
        component: RendezVousMedecinComponent
      },
      {
        path: 'rendez-vous/patient/:id',
        component: RendezVousPatientComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule { }
