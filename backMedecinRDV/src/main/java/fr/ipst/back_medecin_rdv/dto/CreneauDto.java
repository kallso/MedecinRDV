package fr.ipst.back_medecin_rdv.dto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class CreneauDto {
    private int idCreneau;
    private Timestamp dateDebut;
    private Timestamp dateFin;

    public int getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(int idCreneau) {
        this.idCreneau = idCreneau;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }


    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreneauDto that = (CreneauDto) o;
        return idCreneau == that.idCreneau &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(dateFin, that.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCreneau, dateDebut, dateFin);
    }
}
