package one.digitalinnovation.EstoqueCerveja.CONTROLLER;


import lombok.AllArgsConstructor;
import one.digitalinnovation.EstoqueCerveja.DTO.CervejaDTO;
import one.digitalinnovation.EstoqueCerveja.SERVICE.CervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cervejas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaController {

    private final CervejaService cervejaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO criarCerveja(@RequestMapping @Valid CervejaDTO cervejaDTO) throws CervejaAlreadyRegisteredException{
        return CervejaService.criarCerveja(cervejaDTO);
    }

    @GetMapping("/{nome}")
    public CervejaDTO findByName(@PathVariable String nome) throws cervejaNotFoundException {
        return CervejaService.findyByName(nome);
    }

    @GetMapping
    public List<CervejaDTO> listCerveja() {
        return cervejaService.listAll();
    }






}
