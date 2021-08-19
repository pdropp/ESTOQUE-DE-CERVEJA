package one.digitalinnovation.EstoqueCerveja.SERVICE;


import one.digitalinnovation.EstoqueCerveja.BUILDER.cervejaDTObuilder;
import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.ENTITY.Cerveja;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaAlreadyRegisteredException;
import one.digitalinnovation.EstoqueCerveja.MAPPER.CervejaMapper;
import one.digitalinnovation.EstoqueCerveja.REPOSITORY.CervejaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Equals;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
;

@ExtendWith(MockitoExtension.class) //Para rodar essa classe de teste unitário ela usará uma extensão do mockito, vai adicionar uma extensão do mockito
public class CervejaServiceTest {

    private static final long INVALID_BEER_ID = 1L;

    @Mock
    private CervejaRepository cervejaRepository;

    private CervejaMapper cervejaMapper = CervejaMapper.INSTANCE;

    @InjectMocks
    private CervejaService cervejaService;


    @Test
    void cervejaAdicionadaCervejaCriada() throws CervejaAlreadyRegisteredException {

        //Dados
      CervejaDTO cervejaDTO =  cervejaDTObuilder.builder().build().tocervejaDTO();
      Cerveja cervejaCriada = CervejaMapper.INSTANCE.toModel(cervejaDTO);

       //Quando
        when(cervejaRepository.findByName(cervejaDTO.getName())).thenReturn(Optional.empty());
        when(cervejaRepository.save(cervejaCriada)).thenReturn(cervejaCriada);

        //Então
        CervejaDTO criadaCervejaDTO = cervejaService.criarCerveja(cervejaDTO);


        Assertions.assertEquals(cervejaDTO.getId(), cervejaCriada.getId());
        Assertions.assertEquals(cervejaDTO.getName(), cervejaCriada.getName());
    }
}
