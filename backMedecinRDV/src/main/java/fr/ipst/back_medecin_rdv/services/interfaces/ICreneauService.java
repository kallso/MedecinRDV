package fr.ipst.back_medecin_rdv.services.interfaces;

import fr.ipst.back_medecin_rdv.entities.CreneauEntity;
import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICreneauService {
    List<CreneauEntity> getAll();
    List<CreneauEntity> findAll();
    CreneauEntity findById(Long id);
    CreneauEntity save(CreneauEntity creneauEntity);
    CreneauEntity update(CreneauEntity creneauEntity);
    void deleteById(Long id);
}
