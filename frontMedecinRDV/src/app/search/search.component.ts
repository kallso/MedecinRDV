import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Subscription} from 'rxjs';
import {MedecinService} from '../services/medecin.service';
import {Medecin} from '../models/medecin.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit, OnDestroy {
  formulaire: FormGroup;
  nomOuSpe = '';
  ville = '';
  medecinsSubscription: Subscription;
  resultatMedecins: Medecin[];

  constructor(private medecinService: MedecinService) {
  }

  ngOnInit(): void {
    this.formulaire = new FormGroup({
      nomOuSpe: new FormControl(this.nomOuSpe),
      ville: new FormControl(this.ville)
    });
  }

  onSubmit() {
    console.log('Recherche envoyée !', this.formulaire.value);
    this.nomOuSpe = this.formulaire.get('nomOuSpe').value.trim();
    this.ville = this.formulaire.get('ville').value.trim();

    this.medecinsSubscription = this.medecinService
      .getMedecins(this.ville, this.nomOuSpe)
      .subscribe(
        (medecins) => {
          console.log('liste résulats médecins : ', medecins);
          this.resultatMedecins = medecins;
        },
        (error) => {
          // TODO : Gestion de l'erreur
        }
      );
  }

  ngOnDestroy(): void {
    if (this.medecinsSubscription) {
      this.medecinsSubscription.unsubscribe();
    }
  }
}
