package fr.ipst.back_medecin_rdv.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rdv", schema = "medecinrdv", catalog = "")
public class RdvEntity {
    private Timestamp heureDebut;

    @Basic
    @Column(name = "heure_debut", nullable = false)
    public Timestamp getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Timestamp heureDebut) {
        this.heureDebut = heureDebut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RdvEntity rdvEntity = (RdvEntity) o;
        return Objects.equals(heureDebut, rdvEntity.heureDebut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heureDebut);
    }
}
