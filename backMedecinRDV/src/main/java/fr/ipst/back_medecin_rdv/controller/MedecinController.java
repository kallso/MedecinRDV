package fr.ipst.back_medecin_rdv.controller;

import fr.ipst.back_medecin_rdv.dto.MedecinDto;
import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import fr.ipst.back_medecin_rdv.mapper.IMedecinMapper;
import fr.ipst.back_medecin_rdv.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecins")
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @Autowired
    private IMedecinMapper medecinMapper;

    // Get All
    @GetMapping
    public ResponseEntity<List<MedecinDto>> getAllMedecins() {
        return ResponseEntity.ok(medecinMapper.listeEntitesVersListeDto(medecinService.getAll()));
    }

    // Save
    @PostMapping
    public ResponseEntity<MedecinDto> createMedecin(@RequestBody final MedecinDto medecinDto) {
        final MedecinEntity saved = medecinService.save(medecinMapper.dtoVersEntite(medecinDto));

        return new ResponseEntity<>(medecinMapper.entiteVersDto(saved), HttpStatus.CREATED);
    }

    // Get One
    @GetMapping(value = "/{id}")
    public ResponseEntity<MedecinDto> getMedecinById(@PathVariable("id") final Long id) {

        final MedecinEntity MedecinEntity = this.medecinService.findById(id);

        return new ResponseEntity<>(medecinMapper.entiteVersDto(MedecinEntity), HttpStatus.OK);
    }

    // Update
    @PutMapping
    public ResponseEntity<MedecinDto> updateMedecin(@RequestBody final MedecinDto medecinDto) {

        final MedecinEntity saved = this.medecinService.update(medecinMapper.dtoVersEntite(medecinDto));

        return new ResponseEntity<>(medecinMapper.entiteVersDto(saved), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteMedecin(@PathVariable("id") final Long id) {
        this.medecinService.deleteById(id);
    }


    //Get by ville
    @GetMapping("/ville={ville}")
    public ResponseEntity<List<MedecinDto>> getMedecinByVille(@PathVariable("ville") final String ville) {
        return ResponseEntity.ok(medecinMapper.listeEntitesVersListeDto(medecinService.findByVille(ville)));
    }

    //Get by ville and (nom or spe)
    @GetMapping("/vns/ville={ville}&nomOuSpe={nomOuSpe}")
    public ResponseEntity<List<MedecinDto>> findByVilleAndNomOrSpecialisation(@PathVariable("ville") final String ville, @PathVariable("nomOuSpe") final String nomOuSpe) {
        return ResponseEntity.ok(medecinMapper.listeEntitesVersListeDto(medecinService.findByVilleAndNomOrSpecialisation(ville, nomOuSpe)));
    }
}
