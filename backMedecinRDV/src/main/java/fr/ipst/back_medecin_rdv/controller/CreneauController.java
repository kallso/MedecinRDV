package fr.ipst.back_medecin_rdv.controller;

import fr.ipst.back_medecin_rdv.dto.CreneauDto;
import fr.ipst.back_medecin_rdv.entities.CreneauEntity;
import fr.ipst.back_medecin_rdv.mapper.ICreneauMapper;
import fr.ipst.back_medecin_rdv.services.CreneauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creneaux")
public class CreneauController {

    @Autowired
    private CreneauService creneauService;

    @Autowired
    private ICreneauMapper creneauMapper;

    // Get All
    @GetMapping
    public ResponseEntity<List<CreneauDto>> getAll() {
        List<CreneauEntity> creneau = creneauService.getAll();
        creneauMapper.listeEntitesVersListeDto(creneau);
        return ResponseEntity.ok(creneauMapper.listeEntitesVersListeDto(creneauService.getAll()));
    }

    // Save
    @PostMapping
    public ResponseEntity<CreneauDto> createCreneau(@RequestBody final CreneauDto creneauDto) {
        final CreneauEntity saved = creneauService.save(creneauMapper.dtoVersEntite(creneauDto));

        return new ResponseEntity<>(creneauMapper.entiteVersDto(saved), HttpStatus.CREATED);
    }

    // Get One
    @GetMapping(value = "/{id}")
    public ResponseEntity<CreneauDto> getCreneauById(@PathVariable("id") final Long id) {

        final CreneauEntity CreneauEntity = this.creneauService.findById(id);

        return new ResponseEntity<>(creneauMapper.entiteVersDto(CreneauEntity), HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CreneauDto> updateCreneau(@RequestBody final CreneauDto creneauDto) {

        final CreneauEntity saved = this.creneauService.update(creneauMapper.dtoVersEntite(creneauDto));

        return new ResponseEntity<>(creneauMapper.entiteVersDto(saved), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteCreneau(@PathVariable("id") final Long id) {
        this.creneauService.deleteById(id);
    }

    /*@PostMapping("/get")
    public ResponseEntity<DataTablesOutput<CreneauDto>> getUser(
            @RequestBody final DataTablesInput input) {

        final List<CreneauDto> user = creneauMapper.entiteVersListeDtoTriee(this.creneauService.findAll(input));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/
}
