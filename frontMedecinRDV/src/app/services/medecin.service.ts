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
      // TODO gérer les erreurs
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

  updateMedecin(medecin: Medecin) {
    return this.http
      .put<Medecin>(
        Ressources.urlBackEnd + Ressources.urlMedecins,
        medecin
      )
      .pipe(
        catchError(MedecinService.manageErrors),
        tap(medecinUpdated => {
          const medecinUpdatedIndex = this.medecins.findIndex(medecinStored => medecinUpdated.idUser === medecinStored.idUser);
          if (medecinUpdatedIndex !== -1) {
            this.medecins[medecinUpdatedIndex] = medecinUpdated;
          }
          this.medecinsChange.next(this.medecins.slice());
        })
      );
  }

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
}
