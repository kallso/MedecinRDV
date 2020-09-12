import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MedecinService} from '../../services/medecin.service';
import {Subscription} from 'rxjs';
import {Medecin} from '../../models/medecin.model';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-profil-medecin',
  templateUrl: './profil-medecin.component.html',
  styleUrls: ['./profil-medecin.component.css']
})
export class ProfilMedecinComponent implements OnInit {
  formProfilMedecin: FormGroup;
  medecin: Medecin;
  medecinUpdateProfil: Subscription;

  constructor(private medecinService: MedecinService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.formProfilMedecin = new FormGroup({
      nom: new FormControl(),
      prenom: new FormControl(),
      mail: new FormControl(),
      telephone: new FormControl(),
      adresse: new FormControl(),
      codePostal: new FormControl(),
      ville: new FormControl(),
      specialisation: new FormControl()
    });

    this.medecinService
      .getMedecin(this.route.snapshot.params.id)
      .subscribe(medecin => {
        this.medecin = medecin;
        this.formProfilMedecin.get('nom').setValue(this.medecin.nom.trim());
        this.formProfilMedecin.get('prenom').setValue(this.medecin.prenom.trim());
        this.formProfilMedecin.get('mail').setValue(this.medecin.mail.trim());
        this.formProfilMedecin.get('telephone').setValue(this.medecin.telephone.trim());
        this.formProfilMedecin.get('adresse').setValue(this.medecin.adresse.trim());
        this.formProfilMedecin.get('codePostal').setValue(this.medecin.codePostal);
        this.formProfilMedecin.get('ville').setValue(this.medecin.ville.trim());
        this.formProfilMedecin.get('specialisation').setValue(this.medecin.specialisation.trim());
      });
  }

  onSubmit() {
    console.log('form envoyé!', this.formProfilMedecin.value);

    /*this.nom = this.formProfilMedecin.get('nom').value.trim();
    this.prenom = this.formProfilMedecin.get('prenom').value.trim();
    this.mail = this.formProfilMedecin.get('mail').value.trim();
    this.telephone = this.formProfilMedecin.get('telephone').value.trim();
    this.adresse = this.formProfilMedecin.get('adresse').value.trim();
    this.codePostal = this.formProfilMedecin.get('codePostal').value.trim();
    this.ville = this.formProfilMedecin.get('ville').value.trim();
    this.specialisation = this.formProfilMedecin.get('specialisation').value.trim();*/

    /*this.medecinUpdateProfil = this.medecinService
      .updateMedecin()
      .subscribe(
        (medecinSauve) => {
          console.log('medecin sauvé', medecinSauve);
        },
        (error) => {
          // TODO : Gestion de l'erreur
        }
      );*/
  }

  deleteMedecin() {
    this.medecinService
      .deleteMedecin(this.route.snapshot.params.id)
      .subscribe(
        result => {
          if (result.status === 200 || result.ok) {
            this.router.navigate(['/']);
          }
        }
      );
  }

  undoPendingChanges() {
    this.formProfilMedecin.reset(this.medecin);
  }

  allowOnlyNumbersOnKeyPress(event: KeyboardEvent) {
    if (event.which < 48 || event.which > 58) {
      return false;
    }
  }

  allowOnlyNumbersOnPaste(event: ClipboardEvent) {
    if (event.clipboardData.getData('Text').match(/[^\d]/)) {
      event.preventDefault();
    }
  }

}
