import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import {Ressources} from '../app.constants';
import {catchError, tap} from 'rxjs/operators';
import {Subject, throwError} from 'rxjs';
import {Medecin} from '../models/medecin.model';

@Injectable({
  providedIn: 'root'
})
export class MedecinService {
  private medecins: Medecin[] = [];
  private unMedecin: Medecin;
  medecinsChange = new Subject<Medecin[]>();

  constructor(private http: HttpClient) {
  }

  private static manageErrors(erreur: HttpErrorResponse) {
    const errorMessage = 'An unknown error occured!';

    if (!erreur.error || !erreur.error.error) {
    }

    return throwError(errorMessage);
  }

  getMedecin(id: number) {
    return this.http.get<Medecin>(Ressources.urlBackEnd + Ressources.urlMedecins + '/' + id).pipe(
      tap(medecin => {
        this.unMedecin = medecin;
      })
    );
  }

  getMedecins(ville: string, nomOuSpe: string) {
    return this.http
      .get<Medecin[]>(
        Ressources.urlBackEnd + Ressources.urlMedecins + '/' + Ressources.urlGetMedecinsByVilleNomOuSpe +
        '/ville=' + ville + '&nomOuSpe=' + nomOuSpe
      )
      .pipe(
        catchError(MedecinService.manageErrors),
        tap(medecins => {
          medecins.forEach(medecin => this.medecins.push(medecin));
          this.medecinsChange.next(this.medecins.slice());
        })
      );
  }

  addMedecin(medecin: Medecin) {
    return this.http
      .post<Medecin>(
        Ressources.urlBackEnd + Ressources.urlMedecins,
        medecin
      )
      .pipe(
        catchError(MedecinService.manageErrors),
        tap(medecinSauve => {
          this.medecins.push(medecinSauve);
          this.medecinsChange.next(this.medecins.slice());
        })
      );
  }

  /*updateMedecin(medecin: Medecin) {
    return this.http
      .put<Medecin>(
        Ressources.urlBackEnd + Ressources.urlMedecins,
        medecin
      )
      .pipe(
        catchError(MedecinService.manageErrors),
        tap(medecin => {
          medecin => this.medecins. push(medecin);
          this.medecinsChange.next(this.medecins.slice());
        })
      );
  }*/

  deleteMedecin(id: number) {
    return this.http
      .delete<HttpResponse<any>>(
        Ressources.urlBackEnd + Ressources.urlMedecins + '/' + id,
        {observe: 'response'}
      )
      .pipe(
        catchError(MedecinService.manageErrors),
        tap(result => {
          this.medecins.splice(id, 1);
          this.medecinsChange.next(this.medecins.slice());
        })
      );
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
        catchError(this.manageErrors),
        tap(coursSauve => {
          this.cours.push(coursSauve);
          this.coursChange.next(this.cours.slice());
        })
      );
  }*/

  /*modifierCours(index: number, coursModifie: Cours) {
    return this.http
      .put<Cours>(
        this.ressources.urlBackEnd +
        this.ressources.urlCours +
        '/' + coursModifie.id,
        coursModifie
      )
      .pipe(
        catchError(this.manageErrors),
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
