import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  formulaire: FormGroup;
  MES = '';
  ville = '';

  constructor() { }

  ngOnInit(): void {
    this.formulaire = new FormGroup({
      MES: new FormControl(this.MES),
      ville: new FormControl(this.ville)
    });
  }

  onSubmit() {
    if (this.formulaire.valid) {
      console.log('Recherche envoyée !');
    }
  }
}
