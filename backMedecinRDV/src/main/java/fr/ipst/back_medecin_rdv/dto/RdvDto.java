package fr.ipst.back_medecin_rdv.dto;

import java.sql.Timestamp;
import java.util.Objects;

public class RdvDto {
    private int id_rdv;
    private Timestamp heureDebut;

    public int getId_rdv() {
        return id_rdv;
    }

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
        RdvDto rdvDto = (RdvDto) o;
        return Objects.equals(heureDebut, rdvDto.heureDebut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heureDebut);
    }
}
