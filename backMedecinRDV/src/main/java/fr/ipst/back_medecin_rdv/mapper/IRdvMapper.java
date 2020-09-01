package fr.ipst.back_medecin_rdv.mapper;

import fr.ipst.back_medecin_rdv.dto.MedecinDto;
import fr.ipst.back_medecin_rdv.dto.RdvDto;
import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import fr.ipst.back_medecin_rdv.entities.RdvEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IRdvMapper {
    RdvDto entiteVersDto(RdvEntity rdvEntity);
    RdvEntity dtoVersEntite(RdvDto rdvDto);
    List<RdvDto> listeEntitesVersListeDto(List<RdvEntity> rdvEntity);
    //List<UserDto> entiteVersListeDtoTriee(List<UserEntity> dataTablesOutput);
}
