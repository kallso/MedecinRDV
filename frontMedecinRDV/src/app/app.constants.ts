import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';

@Injectable()
export class Ressources {
  public urlfrontEnd = environment.urlPortal;
  public urlBackEnd = environment.urlBackEnd;

  public urlUsers = 'api/users';
  public urlMedecins = 'api/patients';
  public urlPatients = 'api/medecins';
}
