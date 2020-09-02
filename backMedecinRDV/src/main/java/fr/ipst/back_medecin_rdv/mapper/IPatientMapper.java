package fr.ipst.back_medecin_rdv.mapper;

import fr.ipst.back_medecin_rdv.dto.MedecinDto;
import fr.ipst.back_medecin_rdv.dto.PatientDto;
import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import fr.ipst.back_medecin_rdv.entities.PatientEntity;
import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IPatientMapper {
    PatientDto entiteVersDto(PatientEntity patientEntity);
    PatientEntity dtoVersEntite(PatientDto patientDto);
    List<PatientDto> listeEntitesVersListeDto(List<PatientEntity> patientEntity);
    //List<UserDto> entiteVersListeDtoTriee(List<UserEntity> dataTablesOutput);
}
