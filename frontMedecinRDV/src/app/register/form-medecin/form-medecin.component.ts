import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-medecin',
  templateUrl: './form-medecin.component.html',
  styleUrls: ['./form-medecin.component.css']
})
export class FormMedecinComponent implements OnInit {
  formMedecin: FormGroup

  constructor() { }

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
      tempsRdv: new FormControl(),
      motDePasse: new FormControl(),
    })
  }
  onSubmit() {
    return null;
  }

}
