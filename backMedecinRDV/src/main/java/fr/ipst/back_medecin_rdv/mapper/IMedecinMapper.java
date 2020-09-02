package fr.ipst.back_medecin_rdv.mapper;

import fr.ipst.back_medecin_rdv.dto.MedecinDto;
import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IMedecinMapper {
    MedecinDto entiteVersDto(MedecinEntity medecinEntity);
    MedecinEntity dtoVersEntite(MedecinDto medecinDto);
    List<MedecinDto> listeEntitesVersListeDto(List<MedecinEntity> medecinEntity);
    //List<UserDto> entiteVersListeDtoTriee(List<UserEntity> dataTablesOutput);
}
