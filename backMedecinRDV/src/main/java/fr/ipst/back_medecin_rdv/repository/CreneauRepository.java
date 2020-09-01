package fr.ipst.back_medecin_rdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreneauRepository extends JpaRepository<CreneauRepository, Integer> {}
