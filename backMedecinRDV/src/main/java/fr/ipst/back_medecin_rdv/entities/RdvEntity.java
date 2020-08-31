package fr.ipst.back_medecin_rdv.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rdv", schema = "medecinrdv")
public class RdvEntity {
    private int id_rdv;
    private Timestamp heureDebut;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rdv", nullable = false)
    public int getId_rdv() {
        return id_rdv;
    }

    @Basic
    @Column(name = "heure_debut", nullable = false)
    public Timestamp getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Timestamp heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }

    /**
    @ManyToMany
    @JoinTable (name = "Patient_Rdv",
                joinColumns = @JoinColumn(name="id_rdv"),
                inverseJoinColumns = @JoinColumn(name="id_patient"))
    private Set<>**/

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
