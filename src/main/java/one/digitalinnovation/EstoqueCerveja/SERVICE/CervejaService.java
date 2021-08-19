package one.digitalinnovation.EstoqueCerveja.SERVICE;

import lombok.AllArgsConstructor;
import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaAlreadyRegisteredException;
import one.digitalinnovation.EstoqueCerveja.MAPPER.CervejaMapper;
import one.digitalinnovation.EstoqueCerveja.REPOSITORY.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaService {

    private final CervejaRepository cervejaRepository;
    private final CervejaMapper cervejaMapper = CervejaMapper.INSTANCE;


    public CervejaDTO criarCerveja(CervejaDTO cervejaDTO) throws CervejaAlreadyRegisteredException {

        
    }

}
