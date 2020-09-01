package fr.ipst.back_medecin_rdv.service;

import fr.ipst.back_medecin_rdv.entities.UserEntity;
import fr.ipst.back_medecin_rdv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    public final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<UserEntity> findAll() {
        return repo.findAll();
    }
}
