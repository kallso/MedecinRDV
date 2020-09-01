package fr.ipst.back_medecin_rdv.services.interfaces;

import fr.ipst.back_medecin_rdv.entities.PatientEntity;
import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientService {
    List<PatientEntity> getAll();
    List<PatientEntity> findAll();
    PatientEntity findById(Long id);
    PatientEntity save(PatientEntity patientEntity);
    PatientEntity update(PatientEntity patientEntity);
    void deleteById(Long id);
}
