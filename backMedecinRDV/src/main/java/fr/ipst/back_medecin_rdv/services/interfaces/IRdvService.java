package fr.ipst.back_medecin_rdv.services.interfaces;

import fr.ipst.back_medecin_rdv.entities.RdvEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRdvService {
    List<RdvEntity> getAll();
    List<RdvEntity> findAll();
    RdvEntity findById(Long id);
    RdvEntity save(RdvEntity rdvEntity);
    RdvEntity update(RdvEntity rdvEntity);
    void deleteById(Long id);
}
