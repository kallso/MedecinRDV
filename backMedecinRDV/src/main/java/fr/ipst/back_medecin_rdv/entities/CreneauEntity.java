package fr.ipst.back_medecin_rdv.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "creneau", schema = "medecinrdv", catalog = "")
public class CreneauEntity {
    private int idCreneau;
    private Timestamp dateDebut;
    private Timestamp dateFin;

    @Id
    @Column(name = "id_creneau", nullable = false)
    public int getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(int idCreneau) {
        this.idCreneau = idCreneau;
    }

    @Basic
    @Column(name = "date_debut", nullable = false)
    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "date_fin", nullable = false)
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
        CreneauEntity that = (CreneauEntity) o;
        return idCreneau == that.idCreneau &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(dateFin, that.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCreneau, dateDebut, dateFin);
    }
}
