package fr.ipst.back_medecin_rdv.services.interfaces;

import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<UserEntity> getAll();
    List<UserEntity> findAll();
    UserEntity findById(Long id);
    UserEntity save(UserEntity userEntity);
    UserEntity update(UserEntity userEntity);
    void deleteById(Long id);
}
