import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  permuteColor(event) {
    const bouton = event.target;

    if (!bouton.classList.contains('cliked')) {
      const bouton2 = document.getElementById(bouton.id === 'js-patient' ? 'js-medecin' : 'js-patient');

      bouton.classList.toggle('white');
      bouton.classList.toggle('blue');
      bouton.classList.add('cliked');

      bouton2.classList.toggle('white');
      bouton2.classList.toggle('blue');
      bouton2.classList.remove('cliked');
    }
  }
}
