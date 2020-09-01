package fr.ipst.back_medecin_rdv.mapper;

import fr.ipst.back_medecin_rdv.dto.UserDto;
import fr.ipst.back_medecin_rdv.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IUserMapper {
    UserDto entiteVersDto(UserEntity coursEntity);
    UserEntity dtoVersEntite(UserDto coursDto);
    List<UserDto> listeEntitesVersListeDto(List<UserEntity> coursEntity);
    //List<UserDto> entiteVersListeDtoTriee(List<UserEntity> dataTablesOutput);
}
