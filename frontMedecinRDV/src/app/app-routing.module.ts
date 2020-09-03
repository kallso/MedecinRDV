import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SearchComponent} from './search/search.component';

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

  /*{
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'presentation',
    loadChildren: () => import('./test/test.module').then(m => m.TestModule)
  },
  {
    path: '**',
    component: NotFoundComponent
  }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
