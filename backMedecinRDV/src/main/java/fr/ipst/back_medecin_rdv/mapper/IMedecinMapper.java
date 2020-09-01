package fr.ipst.back_medecin_rdv.mapper;

import fr.ipst.back_medecin_rdv.dto.MedecinDto;
import fr.ipst.back_medecin_rdv.dto.UserDto;
import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IMedecinMapper {
    MedecinDto entiteVersDto(MedecinEntity medecinEntity);
    MedecinEntity dtoVersEntite(MedecinDto medecinDto);
    List<MedecinDto> listeEntitesVersListeDto(List<MedecinEntity> medecinEntity);
    //List<UserDto> entiteVersListeDtoTriee(List<UserEntity> dataTablesOutput);
}
