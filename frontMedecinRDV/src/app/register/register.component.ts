import {Component, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  @ViewChild('patient') patientEl;
  @ViewChild('medecin') medecinEl;

  constructor() {
  }

  ngOnInit(): void {
  }

  permuteColor(event) {
    const bouton = event.target;

    if (!bouton.classList.contains('clicked')) {
      const bouton2 = bouton === this.patientEl.nativeElement ? this.medecinEl.nativeElement : this.patientEl.nativeElement;

      bouton.classList.toggle('white');
      bouton.classList.toggle('blue');
      bouton.classList.add('clicked');

      bouton2.classList.toggle('white');
      bouton2.classList.toggle('blue');
      bouton2.classList.remove('clicked');
    }
  }
}
