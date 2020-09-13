import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SearchComponent} from './search/search.component';
import {LoginComponent} from './login/login.component';
import {NotFoundComponent} from './not-found/not-found.component';

const routes: Routes = [
  {
    path: 'accueil',
    redirectTo: '#',
    pathMatch: 'full'
  },
  {
    path: '',
    component: SearchComponent
  },
  {
    path: 'register',
    loadChildren: () => import('./register/register.module').then(m => m.RegisterModule)
  },
  {
    path: 'profil',
    loadChildren: () => import('./profil/profil.module').then(m => m.ProfilModule)
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
