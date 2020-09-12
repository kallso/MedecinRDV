import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  @ViewChild('patient') patientEl;
  @ViewChild('medecin') medecinEl;

  constructor(private hostElement: ElementRef) {
  }

  ngOnInit(): void {
  }

  permuteColor(event) {
    const bouton = event.target;

    console.log(this.hostElement.nativeElement);

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
