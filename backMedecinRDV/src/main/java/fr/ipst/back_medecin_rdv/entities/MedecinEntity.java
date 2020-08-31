package fr.ipst.back_medecin_rdv.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medecin", schema = "medecinrdv", catalog = "")
public class MedecinEntity {
    private int idMedecin;
    private String specialisation;
    private String adresse;
    private int tempsRdv;
    private int codePostal;
    private String ville;

    @Id
    @Column(name = "id_medecin", nullable = false)
    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    @Basic
    @Column(name = "specialisation", nullable = false, length = 255)
    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Basic
    @Column(name = "adresse", nullable = false, length = 255)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "tempsRDV", nullable = false)
    public int getTempsRdv() {
        return tempsRdv;
    }

    public void setTempsRdv(int tempsRdv) {
        this.tempsRdv = tempsRdv;
    }

    @Basic
    @Column(name = "codePostal", nullable = false)
    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @Basic
    @Column(name = "ville", nullable = false, length = 255)
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
        MedecinEntity that = (MedecinEntity) o;
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
