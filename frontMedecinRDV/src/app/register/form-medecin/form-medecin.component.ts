import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
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
  medecinAddedSubscription: Subscription;
  @ViewChild('tempsRdv', {static: true}) tempsRdvEl;

  constructor(private medecinService: MedecinService) {
  }

  ngOnInit(): void {
    this.formMedecin = new FormGroup({
      nom: new FormControl(),
      prenom: new FormControl(),
      mail: new FormControl(),
      telephone: new FormControl(),
      adresse: new FormControl(),
      codePostal: new FormControl(),
      ville: new FormControl(),
      specialisation: new FormControl(),
      tempsRdv: new FormControl('00:30'),
      password: new FormControl(),
    });

    this.formMedecin.get('tempsRdv').setValidators(control => !this.tempsRdvEl.nativeElement.reportValidity() ? {tempsRdvEl: true} : null);
  }

  onSubmit() {
    console.log('form envoyé!', this.formMedecin.value);

    this.medecinAddedSubscription = this.medecinService
      .addMedecin(this.formMedecin.value)
      .subscribe(
        (medecinSauve) => {
          console.log('medecin sauvé', medecinSauve);
          alert('Profil Créé !');
        },
        (error) => {
          // TODO : Gestion de l'erreur
        }
      );
  }

  ngOnDestroy(): void {
    if (this.medecinAddedSubscription) {
      this.medecinAddedSubscription.unsubscribe();
    }
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
