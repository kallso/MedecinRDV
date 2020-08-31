package fr.ipst.back_medecin_rdv.controller;

import fr.ipst.back_medecin_rdv.entities.UserEntity;
import fr.ipst.back_medecin_rdv.exceptions.RessourceNotFoundException;
import fr.ipst.back_medecin_rdv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    public final UserRepository repo;

    @Autowired
    public UserRestController(UserRepository repo) {
        this.repo = repo;
    }

    //get all
    @GetMapping("/users")
    public List<UserEntity> findAll(){
        return repo.findAll();
    }

    // Save
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity newUser(@Validated @RequestBody UserEntity newUser) {
        return repo.save(newUser);
    }

    // Find
    @GetMapping("/users/{id}")
    UserEntity findOne(@PathVariable int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("user","id",id));
    }

    // Save or update
    @PutMapping("/users/{id}")
    UserEntity saveOrUpdate(@RequestBody UserEntity newUser, @PathVariable int id) {

        return repo.findById(id)
                .map(x -> {
                    x.setPassword(newUser.getPassword());
                    return repo.save(x);
                })
                .orElseGet(() -> {
                    newUser.setIdUser(id);
                    return repo.save(newUser);
                });
    }
}
