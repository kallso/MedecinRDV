package fr.ipst.back_medecin_rdv.mapper;

import fr.ipst.back_medecin_rdv.dto.CreneauDto;
import fr.ipst.back_medecin_rdv.dto.MedecinDto;
import fr.ipst.back_medecin_rdv.entities.CreneauEntity;
import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ICreneauMapper {
    CreneauDto entiteVersDto(CreneauEntity creneauEntity);
    CreneauEntity dtoVersEntite(CreneauDto creneauDto);
    List<CreneauDto> listeEntitesVersListeDto(List<CreneauEntity> creneauEntity);
    //List<UserDto> entiteVersListeDtoTriee(List<UserEntity> dataTablesOutput);
}
