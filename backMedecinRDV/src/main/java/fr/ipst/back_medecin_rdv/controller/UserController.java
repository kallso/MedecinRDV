package fr.ipst.back_medecin_rdv.controller;

import fr.ipst.back_medecin_rdv.dto.UserDto;
import fr.ipst.back_medecin_rdv.entities.UserEntity;
import fr.ipst.back_medecin_rdv.mapper.IUserMapper;
import fr.ipst.back_medecin_rdv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private IUserMapper userMapper;

    // Get All
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserEntity> user = userService.getAll();
        userMapper.listeEntitesVersListeDto(user);
        return ResponseEntity.ok(userMapper.listeEntitesVersListeDto(userService.getAll()));
    }

    // Save
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto) {
        final UserEntity saved = userService.save(userMapper.dtoVersEntite(userDto));

        return new ResponseEntity<>(userMapper.entiteVersDto(saved), HttpStatus.CREATED);
    }

    /*@GetMapping("/test/{id}")
    public ResponseEntity<Long> getUserTestById(@PathVariable("id") final Long id) {
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }*/

    // Get One
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") final Long id) {

        final UserEntity userEntity = this.userService.findById(id);

        return new ResponseEntity<>(userMapper.entiteVersDto(userEntity), HttpStatus.OK);
    }

    // Update
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody final UserDto userDto) {

        final UserEntity saved = this.userService.update(userMapper.dtoVersEntite(userDto));

        return new ResponseEntity<>(userMapper.entiteVersDto(saved), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") final Long id) {
        this.userService.deleteById(id);
    }

    /*@PostMapping("/get")
    public ResponseEntity<DataTablesOutput<UserDto>> getUser(
            @RequestBody final DataTablesInput input) {

        final List<UserDto> user = userMapper.entiteVersListeDtoTriee(this.userService.findAll(input));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/
}
