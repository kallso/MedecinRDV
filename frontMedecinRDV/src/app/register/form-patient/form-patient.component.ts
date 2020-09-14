import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Subscription} from 'rxjs';
import {MedecinService} from '../../services/medecin.service';

@Component({
  selector: 'app-form-patient',
  templateUrl: './form-patient.component.html',
  styleUrls: ['./form-patient.component.css']
})
export class FormPatientComponent implements OnInit, OnDestroy {
  formPatient: FormGroup;
  souscriptionPatientAjoute: Subscription;

  constructor(private userService: MedecinService) {
  }

  ngOnInit(): void {
    this.formPatient = new FormGroup({
      nom: new FormControl(),
      prenom: new FormControl(),
      telephone: new FormControl(),
      mail: new FormControl(),
      password: new FormControl(),
      numSecu: new FormControl()
    });
  }

  onSubmit() {
    this.souscriptionPatientAjoute = this.userService
      .addMedecin(this.formPatient.value)
      .subscribe(
        (userSauve) => {

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
