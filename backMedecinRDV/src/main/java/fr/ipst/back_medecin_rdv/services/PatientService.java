package fr.ipst.back_medecin_rdv.services;

import fr.ipst.back_medecin_rdv.entities.PatientEntity;
import fr.ipst.back_medecin_rdv.repository.IPatientRepository;
import fr.ipst.back_medecin_rdv.services.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository IPatientRepository;

    @Override
    public List<PatientEntity> getAll() {
        return IPatientRepository.findAll();
    }

    @Override
    public List<PatientEntity> findAll() {
        return IPatientRepository.findAll();
    }

    @Override
    public PatientEntity findById(Long id) {
        return IPatientRepository.getOne(id);
    }

    @Override
    public PatientEntity save(PatientEntity newPatient) {
        return IPatientRepository.save(newPatient);
    }

    @Override
    public PatientEntity update(PatientEntity patientEntity) {
        return IPatientRepository.saveAndFlush(patientEntity);
    }

    @Override
    public void deleteById(Long id) {
        IPatientRepository.deleteById(id);
    }
}
