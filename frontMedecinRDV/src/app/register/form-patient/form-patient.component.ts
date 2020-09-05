import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Subscription} from 'rxjs';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-form-patient',
  templateUrl: './form-patient.component.html',
  styleUrls: ['./form-patient.component.css']
})
export class FormPatientComponent implements OnInit, OnDestroy {
  formPatient: FormGroup;
  souscriptionPatientAjoute: Subscription;

  constructor(
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.formPatient = new FormGroup({
      nom: new FormControl(),
      prenom: new FormControl(),
      telephone: new FormControl(),
      // codePostal: new FormControl(),
      // adresse: new FormControl(),
      // ville: new FormControl(),
      // specialisation: new FormControl(),
      mail: new FormControl(),
      // tempsRDV: new FormControl(),
      password: new FormControl(),
    });
  }

  onSubmit() {
    console.log('form envoyé!', this.formPatient.value);

    this.souscriptionPatientAjoute = this.userService
      .ajouterUser(this.formPatient.value)
      .subscribe(
        (userSauve) => {
          console.log('user sauvé', userSauve);
        },
        (error) => {
          // TODO : Gestion de l'erreur
        }
      );
  }

  ngOnDestroy(): void {
    if (this.souscriptionPatientAjoute) {
      this.souscriptionPatientAjoute.unsubscribe();
    }
  }

}
