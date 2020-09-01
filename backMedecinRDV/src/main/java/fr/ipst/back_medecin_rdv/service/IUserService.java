package fr.ipst.back_medecin_rdv.service;

import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<UserEntity> findAll();
}
