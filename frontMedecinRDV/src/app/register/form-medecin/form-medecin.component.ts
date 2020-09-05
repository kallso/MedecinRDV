import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Subscription} from 'rxjs';
import {MedecinService} from '../../services/medecin.service';

@Component({
  selector: 'app-form-medecin',
  templateUrl: './form-medecin.component.html',
  styleUrls: ['./form-medecin.component.css']
})
export class FormMedecinComponent implements OnInit, OnDestroy {
  formMedecin: FormGroup;
  souscriptionMedecinAjoute: Subscription;

  constructor(private medecinService: MedecinService) {}

  ngOnInit(): void {
    this.formMedecin = new FormGroup({
      nom: new FormControl(),
      prenom: new FormControl(),
      telephone: new FormControl(),
      codePostal: new FormControl(),
      adresse: new FormControl(),
      ville: new FormControl(),
      specialisation: new FormControl(),
      mail: new FormControl(),
      tempsRDV: new FormControl(),
      password: new FormControl(),
    });
  }

  onSubmit() {
    console.log('form envoyé!', this.formMedecin.value);

    this.souscriptionMedecinAjoute = this.medecinService
      .ajouterMedecin(this.formMedecin.value)
      .subscribe(
        (medecinSauve) => {
          console.log('medecin sauvé', medecinSauve);
        },
        (error) => {
          // TODO : Gestion de l'erreur
        }
      );
  }

  ngOnDestroy(): void {
    if (this.souscriptionMedecinAjoute) {
      this.souscriptionMedecinAjoute.unsubscribe();
    }
  }

}
