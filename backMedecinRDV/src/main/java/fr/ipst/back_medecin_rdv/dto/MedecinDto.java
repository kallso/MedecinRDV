package fr.ipst.back_medecin_rdv.dto;

import javax.persistence.*;
import java.util.Objects;

public class MedecinDto {
    private int idMedecin;
    private String specialisation;
    private String adresse;
    private int tempsRdv;
    private int codePostal;
    private String ville;

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTempsRdv() {
        return tempsRdv;
    }

    public void setTempsRdv(int tempsRdv) {
        this.tempsRdv = tempsRdv;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedecinDto that = (MedecinDto) o;
        return idMedecin == that.idMedecin &&
                tempsRdv == that.tempsRdv &&
                codePostal == that.codePostal &&
                Objects.equals(specialisation, that.specialisation) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(ville, that.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedecin, specialisation, adresse, tempsRdv, codePostal, ville);
    }
}
