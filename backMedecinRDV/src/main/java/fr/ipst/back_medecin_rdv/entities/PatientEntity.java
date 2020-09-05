package fr.ipst.back_medecin_rdv.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "id_user")
public class PatientEntity extends UserEntity {
    private int numSecu;

    @Basic
    @Column(name = "num_secu", nullable = false)
    public int getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(int numSecu) {
        this.numSecu = numSecu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return numSecu == that.numSecu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSecu);
    }
}
