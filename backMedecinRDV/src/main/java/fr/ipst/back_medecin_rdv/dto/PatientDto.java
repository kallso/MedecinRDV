package fr.ipst.back_medecin_rdv.dto;

import javax.persistence.*;
import java.util.Objects;

public class PatientDto {
    private int idPatient;
    private int numSecu;

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

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
        PatientDto that = (PatientDto) o;
        return idPatient == that.idPatient &&
                numSecu == that.numSecu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatient, numSecu);
    }
}
