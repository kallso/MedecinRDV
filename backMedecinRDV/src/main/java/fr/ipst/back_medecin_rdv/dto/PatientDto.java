package fr.ipst.back_medecin_rdv.dto;

import java.util.Objects;

public class PatientDto extends UserDto {
    private int numSecu;

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
        return numSecu == that.numSecu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSecu);
    }
}
