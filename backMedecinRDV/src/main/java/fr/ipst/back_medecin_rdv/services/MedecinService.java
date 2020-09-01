package fr.ipst.back_medecin_rdv.services;

import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import fr.ipst.back_medecin_rdv.repository.IMedecinRepository;
import fr.ipst.back_medecin_rdv.services.interfaces.IMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MedecinService implements IMedecinService {

    @Autowired
    private IMedecinRepository IMedecinRepository;

    @Override
    public List<MedecinEntity> getAll() {
        return IMedecinRepository.findAll();
    }

    @Override
    public List<MedecinEntity> findAll() {
        return IMedecinRepository.findAll();
    }

    @Override
    public MedecinEntity findById(Long id) {
        return IMedecinRepository.getOne(id);
    }

    @Override
    public MedecinEntity save(MedecinEntity newMedecin) {
        return IMedecinRepository.save(newMedecin);
    }

    @Override
    public MedecinEntity update(MedecinEntity medecinEntity) {
        return IMedecinRepository.saveAndFlush(medecinEntity);
    }

    @Override
    public void deleteById(Long id) {
        IMedecinRepository.deleteById(id);
    }
}
