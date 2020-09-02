import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Ressources} from '../app.constants';
import {User} from '../modeles/user.model';
import {tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MedecinService {

  constructor(private http: HttpClient, private ressources: Ressources) {}

  private cours: Cours[] = [];
  unCours: Cours = new Cours(0, '');
  coursChange = new Subject<Cours[]>();
  listeCoursAssocies: Cours[] = [];

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

  ajouterUser(user: User) {
    return this.http
      .post<User>(
        this.ressources.urlBackEnd + this.ressources.urlUsers,
        user
      )
      .pipe(
        catchError(this.gererErreur),
        tap(userSauve => {
          this.cours.push(userSauve);
          this.coursChange.next(this.cours.slice());
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

  gererErreur(erreur: HttpErrorResponse) {
    const errorMessage = 'An unknown error occured!';

    if (!erreur.error || !erreur.error.error) {
    }
    return throwError(errorMessage);
  }

  getCoursAssocies() {
    return this.listeCoursAssocies.slice();
  }

  setCoursAssocies(cours: Cours[]) {
    this.listeCoursAssocies = cours;
  }*/
}
