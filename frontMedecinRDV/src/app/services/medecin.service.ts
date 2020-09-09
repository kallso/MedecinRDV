import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Ressources} from '../app.constants';
import {catchError, tap} from 'rxjs/operators';
import {Subject, throwError} from 'rxjs';
import {Medecin} from '../models/medecin.model';

@Injectable({
  providedIn: 'root'
})
export class MedecinService {
  private medecins: Medecin[] = [];
  medecinsChange = new Subject<Medecin[]>();

  constructor(private http: HttpClient, private ressources: Ressources) {}
  
  /* eviter methodes en francais*/

  private static gererErreur(erreur: HttpErrorResponse) {
    const errorMessage = 'An unknown error occured!';

    if (!erreur.error || !erreur.error.error) {
    }
    return throwError(errorMessage);
  }

  /*setCours(cours: Cours[]) {
    this.cours = cours;
    this.coursChange.next(this.cours.slice());
  }

  getCours() {
    return this.cours.slice();
  }

  getUnCours(index: number) {
    return this.cours[index];
  }

  getDetailCours(id: number) {
    return this.http.get<Cours>(this.ressources.urlBackEnd + this.ressources.urlCours + '/' + id).pipe(
      tap(result => {
        this.unCours = result;
        return result;
      })
    );
  }

  getCoursConsulte() {
    return this.unCours;
  }

  ajouterCours(cours: Cours) {
    return this.http
      .post<Cours>(
        this.ressources.urlBackEnd + this.ressources.urlCours,
        cours
      )
      .pipe(
        catchError(this.gererErreur),
        tap(coursSauve => {
          this.cours.push(coursSauve);
          this.coursChange.next(this.cours.slice());
        })
      );
  }*/
  
  
  /* eviter methodes en francais*/


  ajouterMedecin(medecin: Medecin) {
    return this.http
      .post<Medecin>(
        this.ressources.urlBackEnd + this.ressources.urlMedecins,
        medecin
      )
      .pipe(
        catchError(MedecinService.gererErreur),
        tap(medecinSauve => {
          this.medecins.push(medecinSauve);
          this.medecinsChange.next(this.medecins.slice());
        })
      );
  }

  /*modifierCours(index: number, coursModifie: Cours) {
    return this.http
      .put<Cours>(
        this.ressources.urlBackEnd +
        this.ressources.urlCours +
        '/' + coursModifie.id,
        coursModifie
      )
      .pipe(
        catchError(this.gererErreur),
        tap(cours => {
          this.cours[index] = cours;
          this.coursChange.next(this.cours.slice());
        })
      );
  }

  supprimerCours(index: number) {
    const coursASupprimer = this.getUnCours(index);
    this.http
      .delete(this.ressources.urlBackEnd + this.ressources.urlCours + '/' + coursASupprimer.id)
      .subscribe(
        res => {
          this.cours.splice(index, 1);
          this.coursChange.next(this.cours.slice());
        },
        error => {}
      );
  }

  getCoursAssocies() {
    return this.listeCoursAssocies.slice();
  }

  setCoursAssocies(cours: Cours[]) {
    this.listeCoursAssocies = cours;
  }*/

}
