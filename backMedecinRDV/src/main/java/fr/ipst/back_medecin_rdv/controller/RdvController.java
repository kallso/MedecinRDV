package fr.ipst.back_medecin_rdv.controller;

import fr.ipst.back_medecin_rdv.dto.RdvDto;
import fr.ipst.back_medecin_rdv.entities.RdvEntity;
import fr.ipst.back_medecin_rdv.mapper.IRdvMapper;
import fr.ipst.back_medecin_rdv.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rdv")
public class RdvController {

    @Autowired
    private RdvService rdvService;

    @Autowired
    private IRdvMapper rdvMapper;

    // Get All
    @GetMapping
    public ResponseEntity<List<RdvDto>> getAllRdvs() {
        List<RdvEntity> rdv = rdvService.getAll();
        rdvMapper.listeEntitesVersListeDto(rdv);
        return ResponseEntity.ok(rdvMapper.listeEntitesVersListeDto(rdvService.getAll()));
    }

    // Save
    @PostMapping
    public ResponseEntity<RdvDto> createRdv(@RequestBody final RdvDto rdvDto) {
        final RdvEntity saved = rdvService.save(rdvMapper.dtoVersEntite(rdvDto));

        return new ResponseEntity<>(rdvMapper.entiteVersDto(saved), HttpStatus.CREATED);
    }

    // Get One
    @GetMapping(value = "/{id}")
    public ResponseEntity<RdvDto> getRdvById(@PathVariable("id") final Long id) {

        final RdvEntity RdvEntity = this.rdvService.findById(id);

        return new ResponseEntity<>(rdvMapper.entiteVersDto(RdvEntity), HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<RdvDto> updateRdv(@RequestBody final RdvDto rdvDto) {

        final RdvEntity saved = this.rdvService.update(rdvMapper.dtoVersEntite(rdvDto));

        return new ResponseEntity<>(rdvMapper.entiteVersDto(saved), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteRdv(@PathVariable("id") final Long id) {
        this.rdvService.deleteById(id);
    }

    /*@PostMapping("/get")
    public ResponseEntity<DataTablesOutput<RdvDto>> getUser(
            @RequestBody final DataTablesInput input) {

        final List<RdvDto> user = rdvMapper.entiteVersListeDtoTriee(this.rdvService.findAll(input));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/
}
