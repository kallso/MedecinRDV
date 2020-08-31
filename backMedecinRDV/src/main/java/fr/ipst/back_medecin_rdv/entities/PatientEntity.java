package fr.ipst.back_medecin_rdv.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patient", schema = "medecinrdv", catalog = "")
public class PatientEntity {
    private int idPatient;
    private int numSecu;

    @Id
    @Column(name = "id_patient", nullable = false)
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

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
        return idPatient == that.idPatient &&
                numSecu == that.numSecu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatient, numSecu);
    }
}
