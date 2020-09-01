package fr.ipst.back_medecin_rdv.repository;

import fr.ipst.back_medecin_rdv.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {}
