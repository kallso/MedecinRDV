package fr.ipst.back_medecin_rdv.controller;

import fr.ipst.back_medecin_rdv.dto.PatientDto;
import fr.ipst.back_medecin_rdv.entities.PatientEntity;
import fr.ipst.back_medecin_rdv.mapper.IPatientMapper;
import fr.ipst.back_medecin_rdv.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private IPatientMapper patientMapper;

    // Get All
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAll() {
        List<PatientEntity> patient = patientService.getAll();
        patientMapper.listeEntitesVersListeDto(patient);
        return ResponseEntity.ok(patientMapper.listeEntitesVersListeDto(patientService.getAll()));
    }

    // Save
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody final PatientDto patientDto) {
        final PatientEntity saved = patientService.save(patientMapper.dtoVersEntite(patientDto));

        return new ResponseEntity<>(patientMapper.entiteVersDto(saved), HttpStatus.CREATED);
    }

    // Get One
    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") final Long id) {

        final PatientEntity PatientEntity = this.patientService.findById(id);

        return new ResponseEntity<>(patientMapper.entiteVersDto(PatientEntity), HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody final PatientDto patientDto) {

        final PatientEntity saved = this.patientService.update(patientMapper.dtoVersEntite(patientDto));

        return new ResponseEntity<>(patientMapper.entiteVersDto(saved), HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable("id") final Long id) {
        this.patientService.deleteById(id);
    }

    /*@PostMapping("/get")
    public ResponseEntity<DataTablesOutput<PatientDto>> getUser(
            @RequestBody final DataTablesInput input) {

        final List<PatientDto> user = patientMapper.entiteVersListeDtoTriee(this.patientService.findAll(input));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/
}
