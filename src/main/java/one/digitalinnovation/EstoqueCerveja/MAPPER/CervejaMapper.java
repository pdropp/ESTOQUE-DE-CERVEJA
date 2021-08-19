package one.digitalinnovation.EstoqueCerveja.MAPPER;

import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.ENTITY.Cerveja;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CervejaMapper {

    CervejaMapper INSTANCE = Mappers.getMapper(CervejaMapper.class);

    Cerveja toModel(CervejaDTO cervejaDTO);

    CervejaDTO toDTO(Cerveja cerveja);

}

