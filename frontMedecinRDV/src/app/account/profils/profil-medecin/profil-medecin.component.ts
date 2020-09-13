import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MedecinService} from '../../../services/medecin.service';
import {Subscription} from 'rxjs';
import {Medecin} from '../../../models/medecin.model';
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
      idUser: new FormControl(),
      nom: new FormControl(),
      prenom: new FormControl(),
      mail: new FormControl(),
      telephone: new FormControl(),
      adresse: new FormControl(),
      codePostal: new FormControl(),
      ville: new FormControl(),
      specialisation: new FormControl(),
      tempsRdv: new FormControl(),
      password: new FormControl()
    });

    this.medecinService
      .getMedecin(this.route.snapshot.params.id)
      .subscribe(medecin => {
        this.medecin = medecin;
        this.formProfilMedecin.get('idUser').setValue(this.medecin.idUser);
        this.formProfilMedecin.get('nom').setValue(this.medecin.nom.trim());
        this.formProfilMedecin.get('prenom').setValue(this.medecin.prenom.trim());
        this.formProfilMedecin.get('mail').setValue(this.medecin.mail.trim());
        this.formProfilMedecin.get('telephone').setValue(this.medecin.telephone.trim());
        this.formProfilMedecin.get('adresse').setValue(this.medecin.adresse.trim());
        this.formProfilMedecin.get('codePostal').setValue(this.medecin.codePostal);
        this.formProfilMedecin.get('ville').setValue(this.medecin.ville.trim());
        this.formProfilMedecin.get('specialisation').setValue(this.medecin.specialisation.trim());
        this.formProfilMedecin.get('tempsRdv').setValue(this.medecin.tempsRdv);
        this.formProfilMedecin.get('password').setValue(this.medecin.password.trim());
      });
  }

  onSubmit() {
    console.log('form envoyé!', this.formProfilMedecin.value);

    this.medecinUpdateProfil = this.medecinService
      .updateMedecin(this.formProfilMedecin.value)
      .subscribe(
        (medecinUpdated) => {
          this.medecin = medecinUpdated;
          console.log('medecin sauvé', medecinUpdated);
          alert('Profil mis à jours !');
        },
        (error) => {
          // TODO : Gestion de l'erreur
        }
      );
  }

  deleteMedecin() {
    this.medecinService
      .deleteMedecin(this.route.snapshot.params.id)
      .subscribe(
        result => {
          if (result.status === 200 || result.ok) {
            alert('Profil Supprimé !');
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
