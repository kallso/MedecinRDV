package fr.ipst.back_medecin_rdv.services;

import fr.ipst.back_medecin_rdv.entities.RdvEntity;
import fr.ipst.back_medecin_rdv.repository.IRdvRepository;
import fr.ipst.back_medecin_rdv.services.interfaces.IRdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RdvService implements IRdvService {

    @Autowired
    private IRdvRepository IRdvRepository;

    @Override
    public List<RdvEntity> getAll() {
        return IRdvRepository.findAll();
    }

    @Override
    public List<RdvEntity> findAll() {
        return IRdvRepository.findAll();
    }

    @Override
    public RdvEntity findById(Long id) {
        return IRdvRepository.getOne(id);
    }

    @Override
    public RdvEntity save(RdvEntity newCreneau) {
        return IRdvRepository.save(newCreneau);
    }

    @Override
    public RdvEntity update(RdvEntity rdvEntity) {
        return IRdvRepository.saveAndFlush(rdvEntity);
    }

    @Override
    public void deleteById(Long id) {
        IRdvRepository.deleteById(id);
    }
}
