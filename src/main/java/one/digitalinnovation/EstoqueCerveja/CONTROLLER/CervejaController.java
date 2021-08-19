package one.digitalinnovation.EstoqueCerveja.CONTROLLER;


import lombok.AllArgsConstructor;
import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaAlreadyRegisteredException;
import one.digitalinnovation.EstoqueCerveja.EXCEPTION.CervejaNotFoundException;
import one.digitalinnovation.EstoqueCerveja.SERVICE.CervejaService;
import org.hibernate.result.NoMoreReturnsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cervejas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaController implements CervejaControllerDocs {

    private final CervejaService cervejaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO criarCerverja(@RequestBody @Valid CervejaDTO cervejaDTO) throws CervejaAlreadyRegisteredException {
        return cervejaService.criarCerveja(cervejaDTO);
    }

    @GetMapping("/{nome}")
    public CervejaDTO findByName(@PathVariable String nome) throws CervejaNotFoundException {
        return cervejaService.findByName(nome);
    }


    @GetMapping
    public List<CervejaDTO> listaCervejas() {
        return cervejaService.listAll();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CervejaNotFoundException {
        cervejaService.deleteById(id);
    }




}
