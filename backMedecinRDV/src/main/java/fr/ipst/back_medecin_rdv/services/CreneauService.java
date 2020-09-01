package fr.ipst.back_medecin_rdv.services;

import fr.ipst.back_medecin_rdv.entities.CreneauEntity;
import fr.ipst.back_medecin_rdv.repository.ICreneauRepository;
import fr.ipst.back_medecin_rdv.services.interfaces.ICreneauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CreneauService implements ICreneauService {

    @Autowired
    private ICreneauRepository ICreneauRepository;

    @Override
    public List<CreneauEntity> getAll() {
        return ICreneauRepository.findAll();
    }

    @Override
    public List<CreneauEntity> findAll() {
        return ICreneauRepository.findAll();
    }

    @Override
    public CreneauEntity findById(Long id) {
        return ICreneauRepository.getOne(id);
    }

    @Override
    public CreneauEntity save(CreneauEntity newCreneau) {
        return ICreneauRepository.save(newCreneau);
    }

    @Override
    public CreneauEntity update(CreneauEntity creneauEntity) {
        return ICreneauRepository.saveAndFlush(creneauEntity);
    }

    @Override
    public void deleteById(Long id) {
        ICreneauRepository.deleteById(id);
    }
}
