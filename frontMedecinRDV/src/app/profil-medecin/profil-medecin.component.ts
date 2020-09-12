import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MedecinService } from '../services/medecin.service';

@Component({
  selector: 'app-profil-medecin',
  templateUrl: './profil-medecin.component.html',
  styleUrls: ['./profil-medecin.component.css']
})
export class ProfilMedecinComponent implements OnInit {
  profilMedecin: FormGroup;
  nom = '';
  prenom = '';
  mail = '';
  telephone = '';
  adresse = '';
  codePostal = '';
  ville = '';
  specialisation = '';

  medecinUpdateProfil: Subscription;

  constructor(private medecinService: MedecinService) { }

  ngOnInit(): void {
    this.profilMedecin = new FormGroup({
      nom: new FormControl(),
      prenom: new FormControl(),
      mail: new FormControl(),
      telephone: new FormControl(),
      adresse: new FormControl(),
      codePostal: new FormControl(),
      ville: new FormControl(),
      specialisation: new FormControl(),
    });

  }

  onSubmit() {
    console.log('form envoyé!', this.profilMedecin.value);

    this.nom = this.profilMedecin.get('nom').value.trim();
    this.prenom = this.profilMedecin.get('prenom').value.trim();
    this.mail = this.profilMedecin.get('mail').value.trim();
    this.telephone = this.profilMedecin.get('telephone').value.trim();
    this.adresse = this.profilMedecin.get('adresse').value.trim();
    this.codePostal = this.profilMedecin.get('codePostal').value.trim();
    this.ville = this.profilMedecin.get('ville').value.trim();
    this.specialisation = this.profilMedecin.get('specialisation').value.trim();

    this.medecinUpdateProfil = this.medecinService
      .updateMedecin()
      .subscribe(
        (medecinSauve) => {
          console.log('medecin sauvé', medecinSauve);
        },
        (error) => {
          // TODO : Gestion de l'erreur
        }
      );
  }

}
