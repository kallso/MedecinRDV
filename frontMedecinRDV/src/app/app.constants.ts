import {environment} from '../environments/environment';

/* Après pour le p'tit plus, transformer l'appli en PWA  https://formationjavascript.com/pwa-avec-angular-en-10-etapes/*/
export class Ressources {
  public static readonly urlfrontEnd = environment.urlPortal;
  public static readonly urlBackEnd = environment.urlBackEnd;

  public static readonly urlUsers = 'api/users';
  public static readonly urlMedecins = 'api/medecins';
  public static readonly urlGetMedecinsByVilleNomOuSpe = 'vns';
  public static readonly urlPatients = 'api/patients';

  public static readonly urlUpdateMedecin = 'api/profilMedecin';
}
