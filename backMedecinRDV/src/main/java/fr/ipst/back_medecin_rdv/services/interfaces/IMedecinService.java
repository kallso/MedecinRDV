package fr.ipst.back_medecin_rdv.services.interfaces;

import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMedecinService {
    List<MedecinEntity> getAll();
    List<MedecinEntity> findAll();
    MedecinEntity findById(Long id);
    MedecinEntity save(MedecinEntity medecinEntity);
    MedecinEntity update(MedecinEntity medecinEntity);
    void deleteById(Long id);
}
