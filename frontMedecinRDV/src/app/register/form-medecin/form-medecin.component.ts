import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {Subscription} from 'rxjs';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-form-medecin',
  templateUrl: './form-medecin.component.html',
  styleUrls: ['./form-medecin.component.css']
})
export class FormMedecinComponent implements OnInit, OnDestroy {
  formMedecin: FormGroup;
  souscriptionUserAjoute: Subscription;

  constructor(
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.formMedecin = new FormGroup({
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
    console.log('form envoyé!', this.formMedecin.value);

    this.souscriptionUserAjoute = this.userService
      .ajouterUser(this.formMedecin.value)
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
    if (this.souscriptionUserAjoute) {
      this.souscriptionUserAjoute.unsubscribe();
    }
  }

}
