import {User} from './user.model';

export class Medecin extends User {
  constructor(
    nom: string,
    prenom: string,
    mail: string,
    password: string,
    telephone: string,
    public specialisation: string,
    public adresse: string,
    public tempsRdv: number,
    public codePostal: number,
    public ville: string
  ) {
    super(nom, prenom, mail, password, telephone);
  }
}
