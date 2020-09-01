package fr.ipst.back_medecin_rdv.services;

import fr.ipst.back_medecin_rdv.entities.UserEntity;
import fr.ipst.back_medecin_rdv.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository IUserRepository;

    @Override
    public List<UserEntity> getAll() {
        return IUserRepository.findAll();
    }

    @Override
    public List<UserEntity> findAll() {
        return IUserRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return IUserRepository.getOne(id);
    }

    @Override
    public UserEntity save(UserEntity newUser) {
        return IUserRepository.save(newUser);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return IUserRepository.saveAndFlush(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        IUserRepository.deleteById(id);
    }
}
